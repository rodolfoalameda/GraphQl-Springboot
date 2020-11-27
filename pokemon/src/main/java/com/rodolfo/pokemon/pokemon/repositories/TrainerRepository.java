package com.rodolfo.pokemon.pokemon.repositories;

import com.rodolfo.pokemon.pokemon.entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
}
