package com.udemy.graphql.compras.repositories;

import com.udemy.graphql.compras.entities.Cliente;
import com.udemy.graphql.compras.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findAllByCliente(Cliente cliente);
}
