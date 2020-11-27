package com.rodolfo.pokemon.pokemon.repositories;

import com.rodolfo.pokemon.pokemon.entities.Pokemon;
import com.rodolfo.pokemon.pokemon.entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    List<Pokemon> findAllByTrainer(Trainer trainer);
}
