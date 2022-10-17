package com.alexandre.swapi.domain.services;

import com.alexandre.swapi.domain.Planet;
import com.alexandre.swapi.domain.repositories.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlanetService {

    private PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Planet create(Planet planet) {
        return planetRepository.save(planet);
    }

    public Optional<Planet> getById(Long id) {

        return planetRepository.findById(id);
    }

    public Optional<Planet> getByName(String name) {

        return planetRepository.findByName(name);
    }

    public void deletePlanets() {
        planetRepository.deleteAll();
    }

}
