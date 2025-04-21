package org.example.finalexamasd.dto.requestDto;

import jakarta.validation.constraints.*;
import java.util.List;

public record AstronautRequestDto(
        @NotBlank @Size(min = 2, max = 20) String firstName,
        @NotBlank @Size(min = 2, max = 20) String lastName,
        @Min(0) @Max(50) int experienceYears,
        @NotEmpty(message = "Astronaut must be assigned to at least one satellite") List<Long> satelliteIds
) {}

