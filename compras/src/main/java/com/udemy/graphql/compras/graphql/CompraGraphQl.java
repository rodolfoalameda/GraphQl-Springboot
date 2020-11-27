package com.udemy.graphql.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.graphql.compras.entities.Compra;
import com.udemy.graphql.compras.inputs.CompraInput;
import com.udemy.graphql.compras.services.ClienteService;
import com.udemy.graphql.compras.services.CompraService;
import com.udemy.graphql.compras.services.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompraGraphQl implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private CompraService compraService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    public Compra compra(Long id) {
        return compraService.compra(id);
    }

    public List<Compra> compras() {
        return compraService.compras();
    }

    public Compra saveCompra(CompraInput input) {
        ModelMapper m = new ModelMapper();
        Compra compra = m.map(input, Compra.class);
        compra.setCliente(clienteService.findById(input.getClienteId()));
        compra.setProduto(produtoService.findById(input.getProdutoId()));
        return compraService.saveCompra(compra);
    }

    public String deleteCompra(Long id) {
        compraService.deleteCompra(id);
        return "Deleção feita com sucesso";
    }

}
