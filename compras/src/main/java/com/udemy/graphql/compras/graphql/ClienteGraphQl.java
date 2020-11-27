package com.udemy.graphql.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.graphql.compras.entities.Cliente;
import com.udemy.graphql.compras.inputs.ClienteInput;
import com.udemy.graphql.compras.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteGraphQl implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteService clienteService;

    public Cliente findById(Long id) {
        return clienteService.findById(id);
    }

    public List<Cliente> findAll() {
        return clienteService.findAll();
    }

    public Cliente save(ClienteInput clienteInput) {
        ModelMapper m = new ModelMapper();
        Cliente cliente = m.map(clienteInput, Cliente.class);
        clienteService.save(cliente);
        return cliente;
    }

    public String deleteById(Long id) {
        clienteService.deleteById(id);
        return "Usuário deletado com sucesso";
    }
}
