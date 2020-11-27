package com.rodolfo.pokemon.pokemon.inputs;

import lombok.Data;

@Data
public class PokemonInput {

    private Long id;
    private String name;
    private Integer level;
    private String type;
    private String weakness;

    private Long trainerId;
}
