package br.com.lucaslnasc.spring_docker.useCases;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.lucaslnasc.spring_docker.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

/**
 * Caso de uso responsável por excluir um produto.
 */
@Service
@RequiredArgsConstructor
public class DeleteProductUseCase {
    
    private final ProductRepository productRepository;

    /**
     * Executa o caso de uso de exclusão de produto.
     *
     * @param id ID do produto a ser excluído
     * @throws EntityNotFoundException se o produto não for encontrado
     */
    public void execute(UUID id) {
        if (!productRepository.existsById(id)) {
            throw new EntityNotFoundException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}
