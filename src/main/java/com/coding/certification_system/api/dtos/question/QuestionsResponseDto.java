package com.coding.certification_system.api.dtos.question;

import java.util.List;
import java.util.UUID;

public record QuestionsResponseDto(UUID idQuestion,
                                   String technology,
                                   String description,
                                   List<AlternativesResponseDto> alternatives) {
}
