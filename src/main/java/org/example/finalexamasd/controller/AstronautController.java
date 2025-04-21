package org.example.finalexamasd.controller;

import lombok.RequiredArgsConstructor;
import org.example.finalexamasd.dto.requestDto.AstronautRequestDto;
import org.example.finalexamasd.dto.responseDto.AstronautResponseDto;
import org.example.finalexamasd.service.AstronautService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/astronauts")
@RequiredArgsConstructor
public class AstronautController {

    private final AstronautService astronautService;

    @PostMapping
    public AstronautResponseDto createAstronaut(@Valid @RequestBody AstronautRequestDto dto) {
        return astronautService.createAstronaut(dto);
    }

    @GetMapping
    public List<AstronautResponseDto> getAllAstronauts() {
        return astronautService.getAllAstronauts();
    }
}

