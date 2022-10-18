package com.alexandre.swapi.domain.services;

import com.alexandre.swapi.domain.Planet;
import com.alexandre.swapi.domain.repositories.PlanetRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.alexandre.swapi.common.PlanetConstants.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlanetServiceTest {

    @InjectMocks
    private PlanetService planetService;

    @Mock
    private PlanetRepository planetRepository;

    //operacao_estado_retorno
    @Test
    public void createPlanet_WithValidData_ReturnPlanet() {
        when(planetRepository.save(PLANET)).thenReturn(PLANET);

        Planet planet = planetService.create(PLANET);

        assertEquals(planet, PLANET);
        assertThat(planet).isEqualTo(PLANET);
    }

    @Test
    public void createPlanet_InvalidData_ThrowsException() {
        when(planetRepository.save(INVALID_PLANET)).thenThrow(RuntimeException.class);

        assertThrows(RuntimeException.class, () -> planetService.create(INVALID_PLANET));
        assertThatThrownBy(() -> planetService.create(INVALID_PLANET)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void getById_ByExistingId_ReturnsPlanet() {
        when(planetRepository.findById(anyLong())).thenReturn(Optional.of(PLANET));

        Optional<Planet> planet = planetService.getById(1l);

        assertTrue(PLANET.equals(planet.get()));
    }

    @Test
    public void getById_ByNotExistingId_ReturnsEmpty() {
        when(planetRepository.findById(anyLong())).thenReturn(Optional.empty());

        Optional<Planet> planet = planetRepository.findById(1l);

        assertTrue(planet.isEmpty());
    }

    @Test
    public void getByName_ByExistingName_ReturnsPlanet() {
        when(planetRepository.findByName(PLANET.getName())).thenReturn(Optional.of(PLANET));

        Optional<Planet> planet = planetRepository.findByName("nome");

        assertTrue(planet.isPresent());
    }

    @Test
    public void getByName_ByNotExistingName_ReturnsEmpty() {
        String name = "outro nome";
        when(planetRepository.findByName(name)).thenReturn(Optional.empty());

        Optional<Planet> planet = planetRepository.findByName(name);

        assertTrue(planet.isEmpty());
    }
}