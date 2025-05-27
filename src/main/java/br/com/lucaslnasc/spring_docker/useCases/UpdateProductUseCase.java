package br.com.lucaslnasc.spring_docker.useCases;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.lucaslnasc.spring_docker.dto.ProductRequestDTO;
import br.com.lucaslnasc.spring_docker.dto.ProductResponseDTO;
import br.com.lucaslnasc.spring_docker.mapper.ProductMapper;
import br.com.lucaslnasc.spring_docker.model.Product;
import br.com.lucaslnasc.spring_docker.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

/**
 * Caso de uso responsável por atualizar um produto existente.
 */
@Service
@RequiredArgsConstructor
public class UpdateProductUseCase {
    
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    /**
     * Executa o caso de uso de atualização de produto.
     *
     * @param id ID do produto a ser atualizado
     * @param requestDTO DTO contendo os novos dados do produto
     * @return DTO com os dados do produto atualizado
     * @throws EntityNotFoundException se o produto não for encontrado
     */
    public ProductResponseDTO execute(UUID id, ProductRequestDTO requestDTO) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
        
        productMapper.updateEntityFromDto(requestDTO, product);
        Product updatedProduct = productRepository.save(product);
        return productMapper.toDTO(updatedProduct);
    }
}
