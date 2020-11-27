package com.udemy.graphql.compras.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.udemy.graphql.compras.entities.Cliente;
import com.udemy.graphql.compras.entities.Compra;
import com.udemy.graphql.compras.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteResolver implements GraphQLResolver<Cliente> {

    @Autowired
    CompraService compraService;

    public List<Compra> compras(Cliente cliente) {
        return compraService.findAllByCliente(cliente);
    }


}
