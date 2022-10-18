package com.alexandre.swapi.domain.services;

import com.alexandre.swapi.domain.Planet;
import com.alexandre.swapi.domain.repositories.PlanetRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Planet> list() {
        return planetRepository.findAll();
    }

    public List<Planet> list(String terrain) {
        return planetRepository.findByTerrain(terrain);
    }

    public List<Planet> list(String terrain, String climate) {
        List<Planet> planets = planetRepository.findByTerrainAndClimate(terrain, climate);

        return planets;
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
