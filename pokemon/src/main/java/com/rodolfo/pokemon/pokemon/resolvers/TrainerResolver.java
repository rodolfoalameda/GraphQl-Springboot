package com.rodolfo.pokemon.pokemon.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.rodolfo.pokemon.pokemon.entities.Pokemon;
import com.rodolfo.pokemon.pokemon.entities.Trainer;
import com.rodolfo.pokemon.pokemon.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrainerResolver implements GraphQLResolver<Trainer> {

    @Autowired
    private PokemonService pokemonService;

    public List<Pokemon> pokemons(Trainer trainer) {
        return pokemonService.findAllByTrainer(trainer);
    }

}
