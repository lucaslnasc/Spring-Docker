package br.com.lucaslnasc.spring_docker.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import br.com.lucaslnasc.spring_docker.dto.ProductRequestDTO;
import br.com.lucaslnasc.spring_docker.dto.ProductResponseDTO;
import br.com.lucaslnasc.spring_docker.model.Product;

/**
 * Interface responsável pelo mapeamento entre entidades Product e seus DTOs.
 * Utiliza MapStruct para gerar automaticamente as implementações dos métodos de conversão.
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {

    /**
     * Instância singleton do mapper, pode ser usada quando injeção de dependência não está disponível.
     */
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    
    /**
     * Converte um ProductRequestDTO para uma entidade Product.
     * Ignora os campos id e createdAt durante a conversão, pois são gerenciados pela aplicação.
     *
     * @param dto O DTO contendo os dados do produto a ser criado
     * @return Uma nova instância de Product com os dados do DTO
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Product toEntity(ProductRequestDTO dto);
    
    /**
     * Converte uma entidade Product para ProductResponseDTO.
     * Mantém todos os campos da entidade no DTO de resposta.
     *
     * @param entity A entidade Product a ser convertida
     * @return Um DTO contendo os dados do produto
     */
    ProductResponseDTO toDTO(Product entity);
    
    /**
     * Atualiza uma entidade Product existente com dados de um ProductRequestDTO.
     * Ignora os campos id e createdAt para preservar os valores originais.
     *
     * @param dto O DTO contendo os novos dados do produto
     * @param entity A entidade Product que será atualizada
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateEntityFromDto(ProductRequestDTO dto, @MappingTarget Product entity);
}
