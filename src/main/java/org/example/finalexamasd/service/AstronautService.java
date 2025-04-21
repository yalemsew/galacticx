package org.example.finalexamasd.service;


import org.example.finalexamasd.dto.requestDto.AstronautRequestDto;
import org.example.finalexamasd.dto.responseDto.AstronautResponseDto;
import org.example.finalexamasd.dto.responseDto.SatelliteResponseDto;
import org.example.finalexamasd.exception.customExceptions.InvalidSatelliteAssignmentException;
import org.example.finalexamasd.model.Astronaut;
import org.example.finalexamasd.model.Satellite;
import org.example.finalexamasd.repository.AstronautRepository;
import org.example.finalexamasd.repository.SatelliteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AstronautService {

    private final AstronautRepository astronautRepository;
    private final SatelliteRepository satelliteRepository;

    public AstronautService(AstronautRepository astronautRepository, SatelliteRepository satelliteRepository) {
        this.astronautRepository = astronautRepository;
        this.satelliteRepository = satelliteRepository;
    }

    public AstronautResponseDto createAstronaut(AstronautRequestDto dto) {
        List<Satellite> satellites = satelliteRepository.findAllById(dto.satelliteIds());

        if (satellites.size() != dto.satelliteIds().size()) {
            throw new InvalidSatelliteAssignmentException("One or more satellite IDs are invalid.");
        }

        Astronaut astronaut = new Astronaut();
        astronaut.setFirstName(dto.firstName());
        astronaut.setLastName(dto.lastName());
        astronaut.setExperienceYears(dto.experienceYears());
        astronaut.setSatellites(satellites);

        Astronaut saved = astronautRepository.save(astronaut);

        return new AstronautResponseDto(
                saved.getId(),
                saved.getFirstName(),
                saved.getLastName(),
                saved.getExperienceYears(),
                saved.getSatellites().stream()
                        .map(sat -> new SatelliteResponseDto(sat.getId(), sat.getName()))
                        .toList()
        );
    }

    public List<AstronautResponseDto> getAllAstronauts() {
        return astronautRepository.findAll().stream()
                .map(astronaut -> new AstronautResponseDto(
                        astronaut.getId(),
                        astronaut.getFirstName(),
                        astronaut.getLastName(),
                        astronaut.getExperienceYears(),
                        astronaut.getSatellites().stream()
                                .map(sat -> new SatelliteResponseDto(sat.getId(), sat.getName()))
                                .toList()
                ))
                .toList();
    }
}

