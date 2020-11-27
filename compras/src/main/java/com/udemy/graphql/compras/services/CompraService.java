package com.udemy.graphql.compras.services;

import com.udemy.graphql.compras.entities.Cliente;
import com.udemy.graphql.compras.entities.Compra;
import com.udemy.graphql.compras.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public List<Compra> compras() {
        List<Compra> lista = compraRepository.findAll();
        return lista;
    }

    public Compra compra(Long id) {
        Optional<Compra> compra = compraRepository.findById(id);
        return compra.get();
    }

    public Compra saveCompra(Compra compra) {
        return compraRepository.save(compra);
    }

    public String deleteCompra(Long id) {
        compraRepository.deleteById(id);
        return "Deleção feita com sucesso";
    }

    public List<Compra> findAllByCliente(Cliente cliente) {
        return compraRepository.findAllByCliente(cliente);
    }
}
