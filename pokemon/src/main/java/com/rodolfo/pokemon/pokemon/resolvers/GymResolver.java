package com.rodolfo.pokemon.pokemon.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.rodolfo.pokemon.pokemon.entities.Gym;
import com.rodolfo.pokemon.pokemon.entities.League;
import com.rodolfo.pokemon.pokemon.services.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GymResolver implements GraphQLResolver<Gym> {

    @Autowired
    private LeagueService leagueService;

    public League league(Gym gym) {
        return leagueService.findById(gym.getLeague().getId());
    }
}
