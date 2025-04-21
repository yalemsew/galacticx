package org.example.finalexamasd.controller;


import lombok.RequiredArgsConstructor;
import org.example.finalexamasd.dto.requestDto.SatelliteRequestDto;
import org.example.finalexamasd.dto.responseDto.SatelliteResponseDto;
import org.example.finalexamasd.service.SatelliteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/satellites")
@RequiredArgsConstructor
public class SatelliteController {

    private final SatelliteService satelliteService;


    @PutMapping("/{id}")
    public SatelliteResponseDto updateSatellite(
            @PathVariable Long id,
            @Valid @RequestBody SatelliteRequestDto dto
    ) {
        return satelliteService.updateSatellite(id, dto);
    }
}

