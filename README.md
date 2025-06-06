# PowerGuard - Sistema Distribuído de Resposta a Falhas de Energia

Este repositório contém a implementação completa do sistema **PowerGuard**, um projeto baseado em uma arquitetura de microsserviços com backend em **Java (Spring Boot)** e banco de dados Oracle (simulado com **H2**). O objetivo do sistema é monitorar, registrar e responder a falhas de energia causadas por eventos extremos.

---

## 📦 Microserviços Incluídos

| Serviço              | Linguagem | Porta Padrão | Responsabilidade Técnica                     |
|----------------------|-----------|--------------|----------------------------------------------|
| `ms-user`            | Java      | 8081         | Autenticação e gerenciamento de usuários     |
| `ms-event`           | Java      | 8082         | Registro de eventos de queda de energia      |
| `ms-location`        | Java      | 8083         | Cadastro e consulta de regiões afetadas      |
| `ms-impact`          | Java      | 8084         | Registro de prejuízos causados               |
| `ms-recommendation`  | Java      | 8085         | Orientações e boas práticas à população      |
| `ms-admin`           | Java      | 8086         | Painel de controle e regras do sistema       |

---

## ▶️ Execução (modo local com H2)

### Pré-requisitos
- Java 17
- Maven instalado
- (Windows) Git Bash ou CMD

### Execução no Windows
```bash
./start-all.bat
```

---

## 🔍 Acesso ao Swagger UI

Cada microserviço possui documentação interativa no Swagger:

- http://localhost:8081/swagger-ui.html
- http://localhost:8082/swagger-ui.html
- http://localhost:8083/swagger-ui.html
- http://localhost:8084/swagger-ui.html
- http://localhost:8085/swagger-ui.html
- http://localhost:8086/swagger-ui.html

---

## 🧪 Banco de Dados

Todos os serviços utilizam **H2 Database (in-memory)** para facilitar testes e simulações locais.

- Interface H2: `http://localhost:{porta}/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`

---

## 📁 Estrutura do Projeto

```
PowerGuard/
├── ms-user/
├── ms-event/
├── ms-location/
├── ms-impact/
├── ms-recommendation/
├── ms-admin/
├── start-all.bat
├── start-all.sh
└── README.md
```

---

## 🎓 Detalhes do Sistema

- Arquitetura em camadas com REST APIs para cada domínio
- Comunicação entre microsserviços possível via API Gateway (simulado)
- Utilização de Swagger para documentação
- Banco simulado com H2 por simplicidade (substituível por Oracle para produção)
- Projeto funcional e pronto para avaliação

---

## ✅ Testes dos Microserviços - PowerGuard

Use os endpoints abaixo para testar cada microserviço do sistema PowerGuard. Utilize ferramentas como **Postman** ou **cURL**. Os exemplos incluem payloads prontos.

| Microserviço         | Método | Endpoint                     | Descrição                           | Exemplo de JSON Body                                                   |
|----------------------|--------|------------------------------|-------------------------------------|------------------------------------------------------------------------|
| **ms-user**          | POST   | `/auth/register`            | Registrar novo usuário              | `{ "name": "Pedro", "email": "a@a.com", "password": "123" }`          |
|                      | POST   | `/auth/login`               | Fazer login                         | `{ "email": "a@a.com", "password": "123" }`                            |
|                      | GET    | `/auth/me`                  | Buscar dados do usuário logado      | Header: `Authorization: Bearer {token}`                               |
| **ms-event**         | POST   | `/event/report`             | Registrar novo evento               | `{ "userId": 1, "description": "Falta de energia em bairro X" }`      |
|                      | GET    | `/event/user/1`             | Listar eventos por usuário          | —                                                                      |
|                      | GET    | `/event/all`                | Listar todos os eventos             | —                                                                      |
|                      | PUT    | `/event/1/status`           | Atualizar status do evento          | `{ "status": "RESOLVED" }`                                            |
| **ms-location**      | POST   | `/location`                 | Registrar nova localização afetada  | `{ "userId": 1, "region": "Zona Norte", "city": "São Paulo" }`        |
|                      | GET    | `/location/user/1`          | Buscar localizações de um usuário   | —                                                                      |
|                      | GET    | `/location/status`          | Listar status de todas as regiões   | —                                                                      |
| **ms-impact**        | POST   | `/impact`                   | Cadastrar impacto causado           | `{ "eventId": 1, "lossValue": 10000, "description": "Queima de equipamentos" }` |
|                      | GET    | `/impact/event/1`           | Buscar impactos de um evento        | —                                                                      |
| **ms-recommendation**| GET    | `/recommendations`          | Listar recomendações                | —                                                                      |
| **ms-admin**         | GET    | `/admin/rules`              | Buscar regras de negócio            | —                                                                      |
|                      | PUT    | `/admin/rules`              | Atualizar regras do sistema         | `{ "maxAlertLevel": 5, "autoNotify": true }`                          |
|                      | GET    | `/admin/logs`               | Consultar logs do sistema           | —                                                                      |

### 🔐 Autenticação
Para acessar endpoints protegidos, use o token JWT obtido via `/auth/login`. Inclua o header:

---

## 👨‍💻 Autores do Projeto

- Pedro Salvitti - RM88166
- Gustavo Lopes - RM98887
