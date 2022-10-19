package com.alexandre.swapi.common;

import com.alexandre.swapi.domain.Planet;

import java.util.ArrayList;
import java.util.List;

public class PlanetConstants {

    public static final Planet PLANET = new Planet("nome", "terreno", "clima");
    public static final Planet INVALID_PLANET = new Planet("", "", "");

    public static final Planet TATOOINE = new Planet(1L, "Tatooine", "desert", "arid");
    public static final Planet ALDERAAN = new Planet(2l,"Alderaan", "grasslands, montains", "temperate");
    public static final Planet YAVINIV = new Planet(3l, "Yavin IV", "jungle, rainforce", "temperate, tropical");

    public static final List<Planet> PLANETS = new ArrayList<>() {
        {
            add(TATOOINE);
            add(ALDERAAN);
            add(YAVINIV);
        }
    };



}
