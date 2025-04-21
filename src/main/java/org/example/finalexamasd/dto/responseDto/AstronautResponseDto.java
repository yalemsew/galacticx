package org.example.finalexamasd.dto.responseDto;

import java.util.List;

public record AstronautResponseDto(
        Long id,
        String firstName,
        String lastName,
        int experienceYears,
        List<SatelliteResponseDto> assignedSatellites
) {}

