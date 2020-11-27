package com.rodolfo.pokemon.pokemon.services;

import com.rodolfo.pokemon.pokemon.entities.Pokemon;
import com.rodolfo.pokemon.pokemon.entities.Trainer;
import com.rodolfo.pokemon.pokemon.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> findAll() {
        List<Pokemon> lista = pokemonRepository.findAll();
        return lista;
    }

    public Pokemon findById(Long id) {
        Optional<Pokemon> pokemon = pokemonRepository.findById(id);
        return pokemon.get();
    }

    public Pokemon save(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public String deleteById(Long id) {
        pokemonRepository.deleteById(id);
        return "Deleção feita com sucesso";
    }

    public List<Pokemon> findAllByTrainer(Trainer trainer) {
        return pokemonRepository.findAllByTrainer(trainer);
    }
}
