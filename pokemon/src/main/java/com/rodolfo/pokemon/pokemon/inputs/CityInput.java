package com.rodolfo.pokemon.pokemon.inputs;

import lombok.Data;

import java.io.Serializable;

@Data
public class CityInput implements Serializable {

    private Long id;
    private String name;
    private Boolean coastline;

    private Long gymId;

    private Long leagueId;
}
