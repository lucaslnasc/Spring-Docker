package br.com.lucaslnasc.spring_docker.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Length(max = 100, message = "Name must be at most 100 characters long")
  @NotBlank(message = "Name cannot be blank")
  private String name;

  @Length(max = 500, message = "Description must be at most 500 characters long")
  @NotBlank(message = "Description cannot be blank")
  private String description;
  
  @Column(nullable = false, precision = 10, scale = 2)
  @Positive(message = "Price must be positive")
  private BigDecimal price;

  @Column(nullable = false)
  @PositiveOrZero(message = "Quantity must be zero or positive")
  private Integer quantity;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
