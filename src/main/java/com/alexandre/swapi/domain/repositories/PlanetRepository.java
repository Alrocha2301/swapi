package com.alexandre.swapi.domain.repositories;

import com.alexandre.swapi.domain.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {

    Optional<Planet> findByName(String name);

    List<Planet> findByTerrainAndClimate(String terrain, String climate);
    List<Planet> findByTerrain(String terrain);
    List<Planet> findByClimate(String climate);
}
