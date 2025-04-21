package org.example.finalexamasd.service;

import org.example.finalexamasd.dto.requestDto.SatelliteRequestDto;
import org.example.finalexamasd.dto.responseDto.SatelliteResponseDto;
import org.example.finalexamasd.exception.customExceptions.ResourceNotFoundException;
import org.example.finalexamasd.exception.customExceptions.SatelliteUpdateNotAllowedException;
import org.example.finalexamasd.model.Satellite;
import org.example.finalexamasd.repository.SatelliteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SatelliteService {

    private final SatelliteRepository satelliteRepository;

    public SatelliteService(SatelliteRepository satelliteRepository) {
        this.satelliteRepository = satelliteRepository;
    }

    public SatelliteResponseDto updateSatellite(Long id, SatelliteRequestDto dto) {
        Satellite satellite = satelliteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Satellite not found with ID: " + id));

        if (satellite.isDecommissioned()) {
            throw new SatelliteUpdateNotAllowedException("Cannot update a decommissioned satellite.");
        }

        satellite.setName(dto.name());
        satellite.setLaunchDate(dto.launchDate());
        satellite.setOrbitType(dto.orbitType());

        Satellite updated = satelliteRepository.save(satellite);
        return new SatelliteResponseDto(updated.getId(), updated.getName());
    }
}

