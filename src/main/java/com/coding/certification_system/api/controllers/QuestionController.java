package com.coding.certification_system.api.controllers;

import com.coding.certification_system.api.dtos.question.AlternativesResponseDto;
import com.coding.certification_system.api.dtos.question.QuestionsResponseDto;
import com.coding.certification_system.api.entities.Alternative;
import com.coding.certification_system.api.entities.Question;
import com.coding.certification_system.api.repositories.AlternativesRepository;
import com.coding.certification_system.api.repositories.QuestionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AlternativesRepository alternativesRepository;

    @GetMapping("/technology/{technology}")
    public ResponseEntity<List<QuestionsResponseDto>> findAllByTechnology(@PathVariable String technology) {
        List<QuestionsResponseDto> questionsDto = new ArrayList<>();

        var questions = questionRepository.findByTechnology(technology);

        questions.forEach(question -> {
            var alternatives = alternativesRepository.findQuestionAlternatives(question.getId());

            var questionDto = new QuestionsResponseDto(question.getId(),
                    question.getTechnology(),
                    question.getDescription(),
                    alternatives);

            questionsDto.add(questionDto);
        });

        return ResponseEntity.ok(questionsDto);
    }
}
