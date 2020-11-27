package com.rodolfo.pokemon.pokemon.graphql;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.rodolfo.pokemon.pokemon.entities.Gym;
import com.rodolfo.pokemon.pokemon.entities.League;
import com.rodolfo.pokemon.pokemon.inputs.GymInput;
import com.rodolfo.pokemon.pokemon.services.GymService;
import com.rodolfo.pokemon.pokemon.services.LeagueService;
import com.rodolfo.pokemon.pokemon.services.TrainerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GymGraphQl implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private GymService gymService;

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private LeagueService leagueService;

    public List<Gym> gyms() {
        List<Gym> lista = gymService.findAll();
        return lista;
    }

    public Gym gym(Long id) {
        return gymService.findById(id);
    }

    public Gym saveGym(GymInput input) {
        ModelMapper m = new ModelMapper();
        Gym gym = m.map(input, Gym.class);
        gym.setTrainer(trainerService.findById(input.getTrainerId()));
        gym.setLeague(leagueService.findById(input.getLeagueId()));
        return gymService.save(gym);
    }

    public String deleteGym(Long id) {
        gymService.deleteById(id);
        return "Deleção feita com sucesso";
    }
}
