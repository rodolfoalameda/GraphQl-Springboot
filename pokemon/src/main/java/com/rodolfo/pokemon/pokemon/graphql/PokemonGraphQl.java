package com.rodolfo.pokemon.pokemon.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.rodolfo.pokemon.pokemon.entities.Pokemon;
import com.rodolfo.pokemon.pokemon.inputs.PokemonInput;
import com.rodolfo.pokemon.pokemon.services.PokemonService;
import com.rodolfo.pokemon.pokemon.services.TrainerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PokemonGraphQl implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    PokemonService pokemonService;

    @Autowired
    TrainerService trainerService;

    public List<Pokemon> pokemons() {
        List<Pokemon> lista = pokemonService.findAll();
        return lista;
    }

    public Pokemon pokemon(Long id) {
        return pokemonService.findById(id);
    }

    public Pokemon savePokemon(PokemonInput input) {
        ModelMapper m = new ModelMapper();
        Pokemon pokemon = m.map(input, Pokemon.class);
        pokemon.setTrainer(trainerService.findById(input.getTrainerId()));
        return pokemonService.save(pokemon);
    }

    public String deletePokemon(Long id) {
        pokemonService.deleteById(id);
        return "Deleção feita com sucesso";
    }

}
