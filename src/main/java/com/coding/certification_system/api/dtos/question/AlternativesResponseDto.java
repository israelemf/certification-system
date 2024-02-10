package com.coding.certification_system.api.dtos.question;

import java.util.UUID;

public record AlternativesResponseDto(UUID alternativeID,
                                      String description) {
}
