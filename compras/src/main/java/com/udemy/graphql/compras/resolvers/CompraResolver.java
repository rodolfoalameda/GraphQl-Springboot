package com.udemy.graphql.compras.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.udemy.graphql.compras.entities.Cliente;
import com.udemy.graphql.compras.entities.Compra;
import com.udemy.graphql.compras.entities.Produto;
import com.udemy.graphql.compras.services.ClienteService;
import com.udemy.graphql.compras.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompraResolver implements GraphQLResolver<Compra> {

    @Autowired
    ClienteService clienteService;

    @Autowired
    ProdutoService produtoService;

    public Cliente cliente(Compra compra) {
        return clienteService.findById(compra.getCliente().getId());
    }

    public Produto produto(Compra compra) {
        return produtoService.findById(compra.getProduto().getId());
    }

    public Double subTotal(Compra compra) {
        return compra.getQuantidade() * compra.getProduto().getValor();
    }
}
