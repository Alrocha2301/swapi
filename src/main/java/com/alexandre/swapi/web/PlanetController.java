package com.alexandre.swapi.web;

import com.alexandre.swapi.domain.Planet;
import com.alexandre.swapi.domain.services.PlanetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    private PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @PostMapping
    public ResponseEntity<Planet> create(@RequestBody @Valid Planet planet) {
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

    @GetMapping("/name/{name}")
    public ResponseEntity<Planet> getByName(@PathVariable String name) {
        /*Optional<Planet> gettedPlanet = planetService.getByName(name);

        return ResponseEntity.status(HttpStatus.OK).body(gettedPlanet.get());*/

        return planetService.getByName(name).map(planet -> ResponseEntity.ok(planet))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Planet>> getAll(@RequestParam(required = false) String terrain,
                                               @RequestParam(required = false) String climate) {


        return ResponseEntity.ok(planetService.list(terrain, climate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Planet> deleteAll(@PathVariable Long id) {
        planetService.deletePlanet(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
