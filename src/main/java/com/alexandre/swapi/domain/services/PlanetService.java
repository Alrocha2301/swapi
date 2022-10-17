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

    public Planet getById(Long id) {
        Optional<Planet> optional = planetRepository.findById(id);

        return optional.get();
    }

    public Planet getByName(String name) {
        Optional<Planet> optional = planetRepository.findByName(name);

        return optional.get();
    }

    public void deletePlanets() {
        planetRepository.deleteAll();
    }

}
