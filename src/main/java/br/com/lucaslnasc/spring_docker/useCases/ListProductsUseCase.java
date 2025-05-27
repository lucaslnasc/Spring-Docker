package br.com.lucaslnasc.spring_docker.useCases;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lucaslnasc.spring_docker.dto.ProductResponseDTO;
import br.com.lucaslnasc.spring_docker.mapper.ProductMapper;
import br.com.lucaslnasc.spring_docker.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

/**
 * Caso de uso responsável por listar todos os produtos.
 */
@Service
@RequiredArgsConstructor
public class ListProductsUseCase {
    
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    /**
     * Executa o caso de uso de listagem de produtos.
     *
     * @return Lista de DTOs com os dados dos produtos encontrados
     */
    public List<ProductResponseDTO> execute() {
        return productRepository.findAll().stream()
            .map(productMapper::toDTO)
            .toList();
    }
}
