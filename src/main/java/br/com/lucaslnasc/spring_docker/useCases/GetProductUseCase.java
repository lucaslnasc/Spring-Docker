package br.com.lucaslnasc.spring_docker.useCases;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.lucaslnasc.spring_docker.dto.ProductResponseDTO;
import br.com.lucaslnasc.spring_docker.mapper.ProductMapper;
import br.com.lucaslnasc.spring_docker.model.Product;
import br.com.lucaslnasc.spring_docker.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

/**
 * Caso de uso responsável por buscar um produto por ID.
 */
@Service
@RequiredArgsConstructor
public class GetProductUseCase {
    
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    /**
     * Executa o caso de uso de busca de produto por ID.
     *
     * @param id ID do produto a ser buscado
     * @return DTO com os dados do produto encontrado
     * @throws EntityNotFoundException se o produto não for encontrado
     */
    public ProductResponseDTO execute(UUID id) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
        return productMapper.toDTO(product);
    }
}
