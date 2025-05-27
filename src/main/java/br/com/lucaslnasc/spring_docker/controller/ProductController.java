package br.com.lucaslnasc.spring_docker.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucaslnasc.spring_docker.dto.ProductRequestDTO;
import br.com.lucaslnasc.spring_docker.dto.ProductResponseDTO;
import br.com.lucaslnasc.spring_docker.useCases.CreateProductUseCase;
import br.com.lucaslnasc.spring_docker.useCases.DeleteProductUseCase;
import br.com.lucaslnasc.spring_docker.useCases.GetProductUseCase;
import br.com.lucaslnasc.spring_docker.useCases.ListProductsUseCase;
import br.com.lucaslnasc.spring_docker.useCases.UpdateProductUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Tag(name = "Products", description = "API para gerenciamento de produtos")
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final GetProductUseCase getProductUseCase;
    private final ListProductsUseCase listProductsUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;

    @PostMapping
    @Operation(summary = "Criar um novo produto")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody @Valid ProductRequestDTO request) {
        ProductResponseDTO response = createProductUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar um produto por ID")
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable UUID id) {
        ProductResponseDTO response = getProductUseCase.execute(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @Operation(summary = "Listar todos os produtos")
    public ResponseEntity<List<ProductResponseDTO>> listProducts() {
        List<ProductResponseDTO> response = listProductsUseCase.execute();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um produto existente")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @PathVariable UUID id,
            @RequestBody @Valid ProductRequestDTO request) {
        ProductResponseDTO response = updateProductUseCase.execute(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um produto")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        deleteProductUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}
