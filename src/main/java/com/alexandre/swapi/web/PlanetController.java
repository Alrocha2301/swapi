package com.alexandre.swapi.web;

import com.alexandre.swapi.domain.Planet;
import com.alexandre.swapi.domain.services.PlanetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    private PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @PostMapping
    public ResponseEntity<Planet> create(@RequestBody Planet planet) {
        Planet createdPlanet = planetService.create(planet);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlanet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planet> getById(@PathVariable Long id) {
        Optional<Planet> gettedPlanet = planetService.getById(id);

        if (gettedPlanet.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(gettedPlanet.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/names/{name}")
    public ResponseEntity<Planet> getById(@PathVariable String name) {
        Optional<Planet> gettedPlanet = planetService.getByName(name);

        return ResponseEntity.status(HttpStatus.OK).body(gettedPlanet.get());
    }

    @DeleteMapping
    public ResponseEntity<Planet> deleteAll() {
        planetService.deletePlanets();

        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
