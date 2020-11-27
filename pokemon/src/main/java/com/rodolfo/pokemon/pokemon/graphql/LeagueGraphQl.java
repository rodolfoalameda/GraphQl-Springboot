package com.rodolfo.pokemon.pokemon.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.rodolfo.pokemon.pokemon.entities.League;
import com.rodolfo.pokemon.pokemon.inputs.LeagueInput;
import com.rodolfo.pokemon.pokemon.services.LeagueService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LeagueGraphQl implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private LeagueService leagueService;

    public List<League> leagues() {
        return leagueService.findAll();
    }

    public League league(Long id) {
        return leagueService.findById(id);
    }

    public League saveLeague(LeagueInput input) {
        ModelMapper m = new ModelMapper();
        League league = m.map(input, League.class);
        return leagueService.save(league);
    }

    public String deleteLeague(Long id) {
        return leagueService.deleteById(id);
    }
}
