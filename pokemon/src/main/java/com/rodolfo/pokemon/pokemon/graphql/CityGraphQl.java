package com.rodolfo.pokemon.pokemon.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.rodolfo.pokemon.pokemon.entities.City;
import com.rodolfo.pokemon.pokemon.inputs.CityInput;
import com.rodolfo.pokemon.pokemon.services.CityService;
import com.rodolfo.pokemon.pokemon.services.GymService;
import com.rodolfo.pokemon.pokemon.services.LeagueService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityGraphQl implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private CityService cityService;

    @Autowired
    private GymService gymService;

    @Autowired
    private LeagueService leagueService;

    public List<City> cities() {
        return cityService.findAll();
    }

    public City city(Long id) {
        return cityService.findById(id);
    }

    public City saveCity(CityInput input) {
        ModelMapper m = new ModelMapper();
        City city = m.map(input, City.class);
        city.setGym(gymService.findById(input.getGymId()));
        city.setLeague(leagueService.findById(input.getLeagueId()));
        return cityService.save(city);
    }

    public String deleteCity(Long id) {
        cityService.deleteById(id);
        return "Deleção feita com sucesso";
    }
}
