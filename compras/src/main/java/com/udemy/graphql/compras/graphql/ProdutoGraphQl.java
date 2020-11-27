package com.udemy.graphql.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.graphql.compras.entities.Produto;
import com.udemy.graphql.compras.inputs.ProdutoInput;
import com.udemy.graphql.compras.services.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoGraphQl implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private ProdutoService produtoService;

    public Produto pFindById(Long id) {
        return produtoService.findById(id);
    }

    public List<Produto> pFindAll() {
        return produtoService.findAll();
    }

    public Produto pSave(ProdutoInput input) {
        ModelMapper m = new ModelMapper();
        Produto produto = m.map(input, Produto.class);
        return produtoService.save(produto);
    }

    public String pDeleteById(Long id) {
        produtoService.deleteById(id);
        return "Deleção feita com sucesso";
    }


}
