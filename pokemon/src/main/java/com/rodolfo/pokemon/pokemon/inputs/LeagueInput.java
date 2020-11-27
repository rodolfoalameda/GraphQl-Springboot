package com.rodolfo.pokemon.pokemon.inputs;

import lombok.Data;

import java.io.Serializable;

@Data
public class LeagueInput implements Serializable {

    private Long id;
    private String name;
}
