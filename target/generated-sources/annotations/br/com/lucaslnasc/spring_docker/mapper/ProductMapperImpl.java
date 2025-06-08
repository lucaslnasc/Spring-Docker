package br.com.lucaslnasc.spring_docker.mapper;

import br.com.lucaslnasc.spring_docker.dto.ProductRequestDTO;
import br.com.lucaslnasc.spring_docker.dto.ProductResponseDTO;
import br.com.lucaslnasc.spring_docker.model.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-08T17:59:22-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toEntity(ProductRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.description( dto.getDescription() );
        product.name( dto.getName() );
        product.price( dto.getPrice() );
        product.quantity( dto.getQuantity() );

        return product.build();
    }

    @Override
    public ProductResponseDTO toDTO(Product entity) {
        if ( entity == null ) {
            return null;
        }

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        productResponseDTO.setCreatedAt( entity.getCreatedAt() );
        productResponseDTO.setDescription( entity.getDescription() );
        productResponseDTO.setId( entity.getId() );
        productResponseDTO.setName( entity.getName() );
        productResponseDTO.setPrice( entity.getPrice() );
        productResponseDTO.setQuantity( entity.getQuantity() );

        return productResponseDTO;
    }

    @Override
    public void updateEntityFromDto(ProductRequestDTO dto, Product entity) {
        if ( dto == null ) {
            return;
        }

        entity.setDescription( dto.getDescription() );
        entity.setName( dto.getName() );
        entity.setPrice( dto.getPrice() );
        entity.setQuantity( dto.getQuantity() );
    }
}
