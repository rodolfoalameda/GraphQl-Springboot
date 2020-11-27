package com.rodolfo.pokemon.pokemon.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.rodolfo.pokemon.pokemon.entities.Pokemon;
import com.rodolfo.pokemon.pokemon.entities.Trainer;
import com.rodolfo.pokemon.pokemon.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PokemonResolver implements GraphQLResolver<Pokemon> {

    @Autowired
    private TrainerService trainerService;

    public Trainer trainer(Pokemon pokemon) {
        return trainerService.findById(pokemon.getTrainer().getId());
    }
}
