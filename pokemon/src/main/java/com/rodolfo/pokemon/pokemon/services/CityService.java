package com.rodolfo.pokemon.pokemon.services;

import com.rodolfo.pokemon.pokemon.entities.City;
import com.rodolfo.pokemon.pokemon.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> findAll() {
        List<City> lista = cityRepository.findAll();
        return lista;
    }

    public City findById(Long id) {
        Optional<City> city = cityRepository.findById(id);
        return city.get();
    }

    public City save(City city) {
        return cityRepository.save(city);
    }

    public String deleteById(Long id) {
        cityRepository.deleteById(id);
        return "Deleção feita com sucesso";
    }
}
