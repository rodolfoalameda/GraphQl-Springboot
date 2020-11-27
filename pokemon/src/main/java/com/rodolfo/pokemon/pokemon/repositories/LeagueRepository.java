package com.rodolfo.pokemon.pokemon.repositories;

import com.rodolfo.pokemon.pokemon.entities.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {
}
