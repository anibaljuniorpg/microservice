# Microserviço - Gerenciamento de Eventos

Este microserviço é responsável pelo gerenciamento de eventos, incluindo a criação, listagem e registro de participantes.

## Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Banco de Dados (MySQL/PostgreSQL/H2)
- OpenAPI/Swagger (para documentação)
- Docker (opcional)

## Funcionalidades

- Listar todos os eventos
- Listar eventos futuros
- Criar um novo evento
- Registrar participantes em um evento

## Como Executar

1. Clone o repositório:
   ```sh
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```

2. Acesse o diretório do microserviço:
   ```sh
   cd nome-do-microservico
   ```

3. Configure o banco de dados no `application.properties` ou `application.yml`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   ```

4. Execute o microserviço com Maven:
   ```sh
   mvn spring-boot:run
   ```

## Endpoints Principais

### Eventos

- `GET /events` - Retorna todos os eventos
- `GET /events/upcoming` - Retorna eventos futuros
- `POST /events` - Cria um novo evento

### Registro de Participantes

- `POST /events/{eventId}/register` - Registra um participante em um evento

## Autor

- [Anibal Júnior](https://github.com/anibaljuniorpg)


