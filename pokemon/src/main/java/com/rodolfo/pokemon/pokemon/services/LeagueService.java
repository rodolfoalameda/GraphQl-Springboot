package com.rodolfo.pokemon.pokemon.services;

import com.rodolfo.pokemon.pokemon.entities.League;
import com.rodolfo.pokemon.pokemon.repositories.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {

    @Autowired
    private LeagueRepository leagueRepository;

    public List<League> findAll() {
        List<League> lista = leagueRepository.findAll();
        return lista;
    }

    public League findById(Long id) {
        Optional<League> league = leagueRepository.findById(id);
        return league.get();
    }

    public League save(League league) {
        return leagueRepository.save(league);
    }

    public String deleteById(Long id) {
        leagueRepository.deleteById(id);
        return "Deleção feita com sucesso";
    }

}
