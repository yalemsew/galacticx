package org.example.finalexamasd.dto.requestDto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record SatelliteRequestDto(
        @NotBlank String name,
        @Past(message = "Launch date must be in the past") LocalDate launchDate,
        @Pattern(regexp = "LEO|MEO|GEO", message = "Orbit type must be one of: LEO, MEO, GEO") String orbitType
) {}

