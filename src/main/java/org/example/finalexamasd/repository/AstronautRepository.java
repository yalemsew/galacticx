package org.example.finalexamasd.repository;


import org.example.finalexamasd.model.Astronaut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AstronautRepository extends JpaRepository<Astronaut, Long> {
}

