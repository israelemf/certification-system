package com.coding.certification_system.api.repositories;

import com.coding.certification_system.api.dtos.question.AlternativesResponseDto;
import com.coding.certification_system.api.entities.Alternative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AlternativesRepository extends JpaRepository<Alternative, UUID> {

    @Query("SELECT NEW com.coding.certification_system.api.dtos.question.AlternativesResponseDto(alternative.id, alternative.description)" +
            " FROM Alternative alternative" +
            " WHERE alternative.question_id = :idQuestion")
    List<AlternativesResponseDto> findQuestionAlternatives(@Param("idQuestion") UUID idQuestion);
}
