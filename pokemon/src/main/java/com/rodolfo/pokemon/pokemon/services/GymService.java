package com.rodolfo.pokemon.pokemon.services;


import com.rodolfo.pokemon.pokemon.entities.Gym;
import com.rodolfo.pokemon.pokemon.repositories.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GymService {

    @Autowired
    private GymRepository gymRepository;

    public List<Gym> findAll() {
        List<Gym> lista = gymRepository.findAll();
        return lista;
    }

    public Gym findById(Long id) {
        Optional<Gym> gym = gymRepository.findById(id);
        return gym.get();
    }

    public Gym save(Gym gym) {
        return gymRepository.save(gym);
    }

    public String deleteById(Long id) {
        gymRepository.deleteById(id);
        return "Deleção feita com sucesso";
    }

}
