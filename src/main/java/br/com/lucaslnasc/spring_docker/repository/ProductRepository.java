package br.com.lucaslnasc.spring_docker.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucaslnasc.spring_docker.model.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
