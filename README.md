# Spring Docker - API de Gerenciamento de Produtos

API REST desenvolvida com Spring Boot para gerenciamento de produtos, utilizando boas práticas de desenvolvimento e arquitetura limpa.

## 🚀 Tecnologias

- Java 17
- Spring Boot 3.5
- PostgreSQL
- Docker
- Swagger/OpenAPI
- MapStruct
- Lombok
- Validation
- JPA/Hibernate

## 📁 Estrutura do Projeto

O projeto segue os princípios de Clean Architecture:

```
src/main/java/br/com/lucaslnasc/spring_docker/
├── controller/         # Controllers da API REST
├── dto/               # Data Transfer Objects
├── mapper/            # Conversores de DTO para Entity e vice-versa
├── model/             # Entidades JPA
├── repository/        # Interfaces de repositório
└── useCases/          # Casos de uso da aplicação
```

## 🛠️ Funcionalidades

- CRUD completo de produtos
- Validação de dados
- Documentação com Swagger
- Respostas padronizadas com mensagens descritivas
- Mapeamento automático entre DTOs e Entidades

## 📝 Requisitos

- Java 17 ou superior
- Maven
- Docker
- PostgreSQL

## ⚙️ Configuração

1. Clone o repositório:
```bash
git clone https://seu-repositorio/spring-docker.git
cd spring-docker
```

2. Configure o banco de dados no arquivo `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

3. Execute a aplicação:
```bash
./mvnw spring-boot:run
```

## 🐳 Executando com Docker

1. Build do projeto:
```bash
./mvnw clean package -DskipTests
```

2. Build e execução dos containers:
```bash
docker-compose up --build
```

A aplicação estará disponível em:
- API: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui.html
- Banco de dados: localhost:5432

### Comandos Docker úteis:

- Parar os containers:
```bash
docker-compose down
```

- Ver logs da aplicação:
```bash
docker-compose logs -f api
```

- Reiniciar um serviço específico:
```bash
docker-compose restart api
```

## 🌐 Endpoints

### Produtos

- `POST /api/products` - Criar novo produto
- `GET /api/products` - Listar todos os produtos
- `GET /api/products/{id}` - Buscar produto por ID
- `PUT /api/products/{id}` - Atualizar produto
- `DELETE /api/products/{id}` - Excluir produto

## 📚 Documentação

A documentação completa da API está disponível através do Swagger UI:
```
http://localhost:8080/swagger-ui.html
```

## 🧪 Exemplo de Uso

### Criar um Produto

```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Produto Teste",
    "description": "Descrição do produto",
    "price": 99.99,
    "quantity": 10
  }'
```

### Resposta

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
