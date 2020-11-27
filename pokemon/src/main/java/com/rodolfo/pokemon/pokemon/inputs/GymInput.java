package com.rodolfo.pokemon.pokemon.inputs;

import lombok.Data;

@Data
public class GymInput {

    private Long id;
    private String description;

    private Long trainerId;

    private Long leagueId;
}
