package com.rodolfo.pokemon.pokemon.services;

import com.rodolfo.pokemon.pokemon.entities.Trainer;
import com.rodolfo.pokemon.pokemon.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

    @Autowired
    TrainerRepository trainerRepository;

    public List<Trainer> findAll() {
        List<Trainer> lista = trainerRepository.findAll();
        return lista;
    }

    public Trainer findById(Long id) {
        Optional<Trainer> trainer = trainerRepository.findById(id);
        return trainer.get();
    }

    public Trainer save(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public String deleteById(Long id) {
        trainerRepository.deleteById(id);
        return "Deleção feita com sucesso";
    }
}
