package br.com.lucaslnasc.spring_docker.useCases;

import org.springframework.stereotype.Service;

import br.com.lucaslnasc.spring_docker.dto.ProductRequestDTO;
import br.com.lucaslnasc.spring_docker.dto.ProductResponseDTO;
import br.com.lucaslnasc.spring_docker.mapper.ProductMapper;
import br.com.lucaslnasc.spring_docker.model.Product;
import br.com.lucaslnasc.spring_docker.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

/**
 * Caso de uso responsável pela criação de produtos.
 */
@Service
@RequiredArgsConstructor
public class CreateProductUseCase {
    
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    /**
     * Executa o caso de uso de criação de produto.
     *
     * @param requestDTO DTO contendo os dados do produto a ser criado
     * @return DTO com os dados do produto criado
     */
    public ProductResponseDTO execute(ProductRequestDTO requestDTO) {
        Product product = productMapper.toEntity(requestDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDTO(savedProduct);
    }
}
