package com.udemy.graphql.compras.services;

import com.udemy.graphql.compras.entities.Produto;
import com.udemy.graphql.compras.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        List<Produto> lista = produtoRepository.findAll();
        return lista;
    }

    public Produto findById(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.get();
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public String deleteById(Long id) {
        produtoRepository.deleteById(id);
        return "Deleção feita com sucesso";
    }
}
