package com.alexandre.swapi.common;

import com.alexandre.swapi.domain.Planet;

public class PlanetConstants {

    public static final Planet PLANET = new Planet("nome", "terreno", "clima");
    public static final Planet INVALID_PLANET = new Planet("", "", "");


}
