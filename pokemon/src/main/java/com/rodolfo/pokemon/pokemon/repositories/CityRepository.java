package com.rodolfo.pokemon.pokemon.repositories;

import com.rodolfo.pokemon.pokemon.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
