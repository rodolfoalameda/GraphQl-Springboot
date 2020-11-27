package com.rodolfo.pokemon.pokemon.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.rodolfo.pokemon.pokemon.entities.Trainer;
import com.rodolfo.pokemon.pokemon.inputs.TrainerInput;
import com.rodolfo.pokemon.pokemon.services.TrainerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrainerGraphQl implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private TrainerService trainerService;

    public List<Trainer> trainers() {
        return trainerService.findAll();
    }

    public Trainer trainer(Long id) {
        return trainerService.findById(id);
    }

    public Trainer saveTrainer(TrainerInput input) {
        ModelMapper m = new ModelMapper();
        Trainer trainer = m.map(input, Trainer.class);
        return trainerService.save(trainer);
    }

    public String deleteTrainer(Long id) {
        trainerService.deleteById(id);
        return "Deleção feita com sucesso";
    }
}
