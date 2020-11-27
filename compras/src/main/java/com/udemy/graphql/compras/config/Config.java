package com.udemy.graphql.compras.config;

import com.udemy.graphql.compras.entities.Cliente;
import com.udemy.graphql.compras.entities.Compra;
import com.udemy.graphql.compras.entities.Produto;
import com.udemy.graphql.compras.repositories.ClienteRepository;
import com.udemy.graphql.compras.repositories.CompraRepository;
import com.udemy.graphql.compras.repositories.ProdutoRepository;
import com.udemy.graphql.compras.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class Config implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    CompraService compraService;

    @Override
    public void run(String... args) throws Exception {

        Cliente c1 = new Cliente(null, "Ricardo", "r@gmail.com");
        Cliente c2 = new Cliente(null, "Laura", "l@gmail.com");
        clienteRepository.saveAll(Arrays.asList(c1, c2));

        Produto p1 = new Produto(null, "Chuteira", 159.00);
        Produto p2 = new Produto(null, "Camisa", 59.00);
        produtoRepository.saveAll(Arrays.asList(p1, p2));

        Compra co1 = new Compra(null, 1, "Pago", c1 , p1);
        compraService.saveCompra(co1);

    }
}
