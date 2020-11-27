package com.udemy.graphql.compras.services;

import com.udemy.graphql.compras.entities.Cliente;
import com.udemy.graphql.compras.entities.Compra;
import com.udemy.graphql.compras.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    public List<Cliente> findAll() {
        List<Cliente> lista = clienteRepository.findAll();
        return lista;
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public String deleteById(Long id) {
        clienteRepository.deleteById(id);
        return "Usuário deletado com sucesso";
    }


}
