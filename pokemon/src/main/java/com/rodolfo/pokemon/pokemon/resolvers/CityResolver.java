package com.rodolfo.pokemon.pokemon.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.rodolfo.pokemon.pokemon.entities.City;
import com.rodolfo.pokemon.pokemon.entities.League;
import com.rodolfo.pokemon.pokemon.services.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityResolver implements GraphQLResolver<City> {

    @Autowired
    private LeagueService leagueService;

    public League league(City city) {
        return leagueService.findById(city.getLeague().getId());
    }


}
