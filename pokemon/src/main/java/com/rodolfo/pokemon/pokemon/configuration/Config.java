package com.rodolfo.pokemon.pokemon.configuration;

import com.rodolfo.pokemon.pokemon.entities.*;
import com.rodolfo.pokemon.pokemon.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class Config implements CommandLineRunner {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private GymRepository gymRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private LeagueRepository leagueRepository;

    @Override
    public void run(String... args) throws Exception {

        Trainer t1 = new Trainer(null, "Blue", 7);
        Trainer t2 = new Trainer(null, "Red", 7);
        trainerRepository.saveAll(Arrays.asList(t1, t2));

        Pokemon p1 = new Pokemon(null, "Blastoise", 79, "Water", "Thunder", t1);
        Pokemon p2 = new Pokemon(null, "Primeape", 61, "Fighter", "Flying", t1);
        Pokemon p3 = new Pokemon(null, "Charizard", 89, "Dragon/Fire", "Thunder/Water", t2);
        Pokemon p4 = new Pokemon(null, "Arcanine", 77, "Fire", "Water", t2);
        pokemonRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

        League l1 = new League(null, "Johto");
        leagueRepository.save(l1);

        Gym g1 = new Gym(null, "Ginasio do Fogo", t2, l1);
        gymRepository.save(g1);

        City c = new City(null, "Cinnabar", false, g1, l1);
        cityRepository.save(c);


    }
}
