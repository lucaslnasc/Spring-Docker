# Spring Docker - API de Gerenciamento de Produtos

API REST desenvolvida com Spring Boot para gerenciamento de produtos, utilizando boas práticas de desenvolvimento e arquitetura limpa.

## 🚀 Tecnologias

- Java 17
- Spring Boot 3.5.0
- PostgreSQL
- Docker
- Swagger/OpenAPI
- MapStruct
- Lombok
- Validation
- JPA/Hibernate

## 📁 Estrutura do Projeto

O projeto segue os princípios de Clean Architecture e organização por camadas:

```
src/main/java/br/com/lucaslnasc/spring_docker/
├── controller/         # Controllers da API REST
│   └── ProductController.java
├── dto/               # Data Transfer Objects
│   ├── ApiResponseDTO.java    # DTO padrão para respostas da API
│   ├── ProductRequestDTO.java # DTO para requisições de produto
│   └── ProductResponseDTO.java # DTO para respostas com produto
├── mapper/            # Conversores de DTO para Entity e vice-versa
│   └── ProductMapper.java    # MapStruct mapper para produtos
├── model/             # Entidades JPA
│   └── Product.java         # Entidade de produto
├── repository/        # Interfaces de repositório
│   └── ProductRepository.java # Repositório JPA para produtos
└── useCases/          # Casos de uso da aplicação
    ├── CreateProductUseCase.java
    ├── DeleteProductUseCase.java
    ├── GetProductUseCase.java
    ├── ListProductsUseCase.java
    └── UpdateProductUseCase.java

src/main/resources/
├── application.properties # Configurações principais
└── application-test.properties # Configurações para testes

src/test/java/...        # Testes da aplicação
```

## 🛠️ Funcionalidades

- CRUD completo de produtos com persistência em PostgreSQL
- Validação de dados com Bean Validation
- Documentação automática com OpenAPI/Swagger
- Respostas padronizadas com mensagens descritivas usando ApiResponseDTO
- Mapeamento automático entre DTOs e Entidades com MapStruct
- Container Docker com multi-stage build
- Testes automatizados com banco de dados H2
- Health checks e métricas via Spring Actuator

## 📝 Requisitos

- Java 17 ou superior
- Maven
- Docker
- PostgreSQL

## ⚙️ Configuração e Execução

### Opção 1: Executando com Docker (Recomendado)

1. Clone o repositório:
```powershell
git clone https://github.com/lucaslnasc/Spring-Docker.git
cd Spring-Docker
```

2. Build do projeto com Maven:
```powershell
./mvnw clean package
```

3. Inicie os containers com Docker Compose:
```powershell
docker-compose up --build
```

O ambiente Docker inclui:
- **API (spring_docker_api)**:
  - Porta: 8080
  - Base URL: http://localhost:8080
  - Swagger UI: http://localhost:8080/swagger-ui.html
  - Health Check: http://localhost:8080/actuator/health

- **PostgreSQL (spring_docker_db)**:
  - Porta: 5432
  - Database: spring_docker
  - Username: postgres
  - Password: postgres
  - Host (interno): postgres
  - Host (externo): localhost

- **Rede Docker**:
  - Nome: spring_network
  - Tipo: bridge
  - Comunicação interna entre containers configurada

### Opção 2: Executando Localmente

1. Configure o PostgreSQL:
   - Inicie apenas o container do banco de dados:
   ```powershell
   docker-compose up -d postgres
   ```
   - O banco estará disponível em localhost:5432

2. Verifique o application.properties:
   - A URL do banco deve estar configurada para usar o nome do container:
   ```properties
   spring.datasource.url=jdbc:postgresql://spring_docker_db:5432/spring_docker
   ```
   - O Docker Compose já mapeia o nome `spring_docker_db` para o container do PostgreSQL

3. Execute a aplicação:
   ```powershell
   # Compilar o projeto
   ./mvnw clean install
   
   # Executar com perfil de desenvolvimento
   ./mvnw spring-boot:run
   ```

4. Verifique a aplicação:
   - API rodando em http://localhost:8080
   - Banco de dados em localhost:5432
   - Swagger UI em http://localhost:8080/swagger-ui.html
   - Health check em http://localhost:8080/actuator/health

## 🐳 Comandos Docker Úteis

1. Build do projeto:
```bash
./mvnw clean package
```

2. Build e execução dos containers:
```bash
docker-compose up --build
```

A aplicação estará disponível em:
- API: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui.html
- Banco de dados: localhost:5432

### Comandos Úteis:

#### Gerenciamento de Containers
```powershell
# Parar todos os containers
docker-compose down

# Parar e remover volumes
docker-compose down -v

# Ver logs em tempo real
docker-compose logs -f

# Ver logs específicos da API
docker-compose logs -f api

# Ver logs do PostgreSQL
docker-compose logs -f postgres

# Reiniciar serviços
docker-compose restart api     # Reinicia só a API
docker-compose restart        # Reinicia tudo
```

#### Verificação de Status
```powershell
# Listar containers em execução
docker ps

# Verificar logs do Spring Boot
docker logs spring_docker_api -f

# Verificar logs do PostgreSQL
docker logs spring_docker_db -f
```

#### Limpeza
```powershell
# Remove todos os containers e redes
docker-compose down

# Remove também os volumes (apaga dados do banco)
docker-compose down -v

# Limpa recursos não utilizados
docker system prune
```

## 🌐 Endpoints

### Produtos

- `POST /api/products` - Criar novo produto
- `GET /api/products` - Listar todos os produtos
- `GET /api/products/{id}` - Buscar produto por ID
- `PUT /api/products/{id}` - Atualizar produto
- `DELETE /api/products/{id}` - Excluir produto

## 📚 Documentação

### API Documentation (Swagger/OpenAPI)
A documentação completa da API está disponível através do Swagger UI em:
```
http://localhost:8080/swagger-ui.html
```

### Monitoramento e Métricas

1. **Health Check**:
   ```
   http://localhost:8080/actuator/health
   ```

2. **Métricas**:
   ```
   http://localhost:8080/actuator/metrics
   ```

### Endpoints Principais

1. **Produtos API** - `/api/products`:
   - `POST /api/products` - Criar produto
   - `GET /api/products` - Listar todos
   - `GET /api/products/{id}` - Buscar por ID
   - `PUT /api/products/{id}` - Atualizar
   - `DELETE /api/products/{id}` - Excluir

Todos os endpoints retornam respostas no formato:
```json
{
  "message": "Mensagem de sucesso/erro",
  "data": {
    // Dados da resposta (produto ou lista de produtos)
  }
}
```

## 🧪 Exemplos de Uso

### 1. Criar um Produto

```powershell
$headers = @{
    "Content-Type" = "application/json"
}

$body = @{
    name = "Produto Teste"
    description = "Descrição do produto"
    price = 99.99
    quantity = 10
} | ConvertTo-Json

Invoke-RestMethod -Uri "http://localhost:8080/api/products" `
                 -Method Post `
                 -Headers $headers `
                 -Body $body
```

### 2. Buscar um Produto

```powershell
$productId = "123e4567-e89b-12d3-a456-426614174000"
Invoke-RestMethod -Uri "http://localhost:8080/api/products/$productId" -Method Get
```

### 3. Atualizar um Produto

```powershell
$productId = "123e4567-e89b-12d3-a456-426614174000"
$body = @{
    name = "Produto Atualizado"
    description = "Nova descrição"
    price = 149.99
    quantity = 20
} | ConvertTo-Json

Invoke-RestMethod -Uri "http://localhost:8080/api/products/$productId" `
                 -Method Put `
                 -Headers $headers `
                 -Body $body
```

### 4. Excluir um Produto

```powershell
$productId = "123e4567-e89b-12d3-a456-426614174000"
Invoke-RestMethod -Uri "http://localhost:8080/api/products/$productId" -Method Delete
```

### Formato de Resposta

Todas as respostas seguem o formato padronizado:

```json
{
  "message": "Produto criado com sucesso!",
  "data": {
    "id": "123e4567-e89b-12d3-a456-426614174000",
    "name": "Produto Teste",
    "description": "Descrição do produto",
    "price": 99.99,
    "quantity": 10,
    "createdAt": "2025-05-27T10:00:00"
  }
}
```

## 🤝 Contribuindo

1. Fork o projeto
2. Crie sua Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a Branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## ✨ Autor

Lucas Nascimento
