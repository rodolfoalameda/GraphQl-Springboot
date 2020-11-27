package com.rodolfo.pokemon.pokemon.inputs;

import com.rodolfo.pokemon.pokemon.entities.Pokemon;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TrainerInput {

    private Long id;
    private String name;
    private Integer insignias;
}
