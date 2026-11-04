# 💈 BarberShop API

API RESTful robusta, assíncrona e escalável para agendamento e gestão de barbearias, desenvolvida com **Java 21** e **Spring Boot 3**.

---

## 🎯 Skills & Competências Demonstradas (Nível Pleno)

Este projeto foi desenhado para aplicar e demonstrar padrões avançados de desenvolvimento corporativo em Java:

### 1. Arquitetura e Design Patterns
* **Clean & Layered Architecture:** Separação estrita de responsabilidades entre Controladores, Serviços de Domínio, DTOs imutáveis e Repositórios.
* **Domain-Driven Design (DDD) Pragmático:** Modelagem rica focada nas regras de negócio de agendamento, restrições temporais e cálculos de disponibilidade.
* **Data Transfer Objects (DTOs) com Java Records:** Imutabilidade nativa sem boilerplate.
* **MapStruct:** Mapeamento performático e type-safe entre Entidades JPA e DTOs em tempo de compilação.
* **Global Exception Handling (RFC 7807):** Tratamento centralizado com `@RestControllerAdvice` e padronização `ProblemDetail`.

### 2. Persistência & Tratamento de Concorrência
* **PostgreSQL + Flyway:** Versionamento estrito de schema de banco de dados via migrations SQL (`V1__...`).
* **Prevenção de Race Conditions (Double-Booking):**
  * Controle de concorrência com **Pessimistic Locking** (`@Lock(LockModeType.PESSIMISTIC_WRITE)`) para reservas de horários simultâneos.
  * Restrições de integridade no banco (`UNIQUE CONSTRAINT` composto de barbeiro e data/hora).
* **Consultas Otimizadas:** Projeções customizadas no Spring Data JPA para cálculo dinâmico de slots livres sem sobrecarregar a memória.

### 3. Segurança & Autenticação
* **Spring Security 6 Stateless:** Autenticação via JSON Web Token (JWT) com verificação HMAC-SHA256.
* **Role-Based Access Control (RBAC):** Restrições declarativas por rota e por método com `@PreAuthorize` para papéis `ROLE_CLIENTE`, `ROLE_BARBEIRO` e `ROLE_ADMIN`.

### 4. Resiliência & Processamento Assíncrono
* **Spring Application Events & `@Async`:** Desacoplamento de processos secundários (disparo de notificações via WhatsApp e processamento de webhooks) para garantir respostas HTTP rápidas (< 100ms).
* **Webhooks Seguros:** Validação de assinaturas criptográficas em webhooks de confirmação de pagamento Pix.

### 5. Qualidade de Software & Testes
* **Testes Unitários:** Cobertura de regras críticas de negócio usando **JUnit 5** e **Mockito**.
* **Testes de Integração:** Uso de **Testcontainers** para validação das consultas SQL e constraints diretamente em uma instância real de PostgreSQL em container.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 21 (LTS)
* **Framework:** Spring Boot 3.3+
* **Segurança:** Spring Security + JJWT
* **Banco de Dados:** PostgreSQL 16
* **Migrations:** Flyway
* **Mapeamento:** MapStruct
* **Documentação:** Springdoc-OpenAPI (Swagger UI)
* **Containers:** Docker & Docker Compose
* **Testes:** JUnit 5, Mockito, Testcontainers

---

## 🚀 Como Executar Localmente

### Pré-requisitos
* Java 21 JDK instalado
* Docker e Docker Compose instalados
* Maven 3.9+ instalado

### Passos
1. **Clone o repositório:**
   ```bash
   git clone https://github.com/nosremehj/barbershop-api.git
   cd barbershop-api
   ```

2. **Inicie o banco de dados PostgreSQL:**
   ```bash
   docker compose up -d
   ```

3. **Configure as variáveis de ambiente:**
   Copie o arquivo `.env.example` para `.env` e ajuste as credenciais se necessário.

4. **Execute a aplicação:**
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Acesse a documentação Swagger:**
   Abra no navegador: `http://localhost:8080/swagger-ui.html`

---

## 📄 Licença
Distribuído sob a licença MIT.
