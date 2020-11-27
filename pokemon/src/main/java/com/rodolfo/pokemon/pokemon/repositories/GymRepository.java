package com.rodolfo.pokemon.pokemon.repositories;

import com.rodolfo.pokemon.pokemon.entities.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymRepository extends JpaRepository<Gym, Long> {
}
