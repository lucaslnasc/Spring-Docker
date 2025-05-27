package br.com.lucaslnasc.spring_docker.dto;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class ProductRequestDTO {
    
    @Length(max = 100, message = "Name must be at most 100 characters long")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Length(max = 500, message = "Description must be at most 500 characters long")
    @NotBlank(message = "Description cannot be blank")
    
    private String description;    @Positive(message = "Price must be positive")
    private BigDecimal price;

    @PositiveOrZero(message = "Quantity must be zero or positive")
    private Integer quantity;
}
