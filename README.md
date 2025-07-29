# 📦 Cápsula do Tempo - Core API

Uma API REST para gerenciamento de cápsulas do tempo, permitindo criar e armazenar mensagens que serão "abertas" em datas futuras específicas.

## 📋 Sobre o Projeto

O **Cápsula do Tempo Core** é uma aplicação Spring Boot que oferece funcionalidades para:

- 🕰️ Criar cápsulas do tempo com datas de expiração
- 💌 Adicionar mensagens às cápsulas
- 📅 Gerenciar cronograma de envio de mensagens
- 📊 Acompanhar status das mensagens (enviadas/pendentes)
- 🔍 Consultar cápsulas e mensagens através de uma API REST

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.3.13**
- **Spring Data JPA**
- **PostgreSQL**
- **Flyway** (migrações de banco)
- **SpringDoc OpenAPI 3** (documentação Swagger)
- **Lombok**
- **Maven**

## 📑 API Endpoints

### Cápsulas
- `GET /api/capsulas/` - Lista todas as cápsulas
- `POST /api/capsulas/` - Cria uma nova cápsula
- `GET /api/capsulas/{id}` - Obtém uma cápsula específica
- `PUT /api/capsulas/{id}` - Atualiza uma cápsula
- `DELETE /api/capsulas/{id}` - Remove uma cápsula

### Mensagens
- `GET /api/capsulas/{id}/mensagens` - Lista mensagens de uma cápsula
- `POST /api/capsulas/{id}/mensagens` - Adiciona mensagem à cápsula
- `GET /api/capsulas/{capsulaId}/mensagens/{id}` - Obtém mensagem específica
- `PUT /api/capsulas/{capsulaId}/mensagens/{id}` - Atualiza uma mensagem
- `DELETE /api/capsulas/{capsulaId}/mensagens/{id}` - Remove uma mensagem

## 🚀 Como Executar o Projeto

### Pré-requisitos

- **Java 21** ou superior
- **PostgreSQL** instalado e rodando
- **Maven** (ou use o wrapper incluído no projeto)

### 1. Clonar o Repositório

```bash
git clone https://github.com/WirisWernek/capsula-do-tempo-core.git
cd capsula-do-tempo-core
```

### 2. Configurar o Banco de Dados

Crie um banco de dados PostgreSQL:

```sql
CREATE DATABASE capsula_do_tempo;
```

### 3. Configurar Variáveis de Ambiente (Opcional)

O projeto já possui configurações padrão no `application.yml`, mas você pode personalizar através de variáveis de ambiente:

```bash
export DATABASE_SERVER=localhost
export DATABASE_PORT=5432
export DATABASE_NAME=capsula_do_tempo
export DATABASE_USER=postgres
export DATABASE_PASSWORD=postgres
```

### 4. Executar a Aplicação

#### Usando Maven Wrapper (Recomendado):

```bash
# No Linux/macOS
./mvnw spring-boot:run

# No Windows
mvnw.cmd spring-boot:run
```

#### Usando Maven instalado:

```bash
mvn spring-boot:run
```

#### Compilar e executar o JAR:

```bash
# Compilar o projeto
./mvnw clean package -DskipTests

# Executar o JAR gerado
java -jar target/capsula-do-tempo-0.0.1-SNAPSHOT.jar
```

### 5. Verificar a Execução

A aplicação estará disponível em:
- **API**: http://localhost:8080
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **Health Check**: http://localhost:8080/actuator/health

## 📚 Documentação da API

A documentação completa da API está disponível através do Swagger:

- **Local**: http://localhost:8080/swagger-ui.html
- **Online**: https://wiriswernek.github.io/capsula-do-tempo-core/

## 🔧 Configurações Principais

### Banco de Dados
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/capsula_do_tempo
    username: postgres
    password: postgres
```

### Servidor
```yaml
server:
  port: 8080
```

### Logs
```yaml
logging:
  file:
    name: log/appfile.log
```

## 🗃️ Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/github/wiriswernek/capsula_do_tempo/
│   │   ├── config/          # Configurações (Swagger)
│   │   ├── controllers/     # Controllers REST
│   │   ├── exceptions/      # Exceções customizadas
│   │   ├── models/
│   │   │   ├── dto/         # Data Transfer Objects
│   │   │   ├── entity/      # Entidades JPA
│   │   │   └── repository/  # Repositórios JPA
│   │   └── services/        # Regras de negócio
│   └── resources/
│       ├── application.yml  # Configurações da aplicação
│       └── db/migration/    # Scripts Flyway
└── test/                    # Testes unitários
```

## 🧪 Executar Testes

```bash
# Executar todos os testes
./mvnw test

# Executar testes com relatório de cobertura
./mvnw test jacoco:report
```

## 🐳 Docker (Futuro)

*Em desenvolvimento - Docker Compose com PostgreSQL será adicionado em breve.*

## 🤝 Contribuindo

1. Faça o fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## 📞 Contato

**Wiris Wernek**
- Email: wiriswernek@gmail.com
- GitHub: [@WirisWernek](https://github.com/WirisWernek)

## 📄 Links Úteis

- **Repositório**: https://github.com/WirisWernek/capsula-do-tempo-core
- **Documentação API**: https://wiriswernek.github.io/capsula-do-tempo-core/