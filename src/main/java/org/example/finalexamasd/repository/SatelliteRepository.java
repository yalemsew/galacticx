package org.example.finalexamasd.repository;

import org.example.finalexamasd.model.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SatelliteRepository extends JpaRepository<Satellite, Long> {
    boolean existsByName(String name); // Optional: useful to validate uniqueness
}

