package br.com.lucaslnasc.spring_docker.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data
public class ProductResponseDTO {
  private UUID id;
  private String name;
  private String description;
  private BigDecimal price;
  private Integer quantity;
  private LocalDateTime createdAt;
}
