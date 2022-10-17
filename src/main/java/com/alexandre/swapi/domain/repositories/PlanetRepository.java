package com.alexandre.swapi.domain.repositories;

import com.alexandre.swapi.domain.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {

    Optional<Planet> findByName(String nome);
}
