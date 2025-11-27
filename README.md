# API de Currículos – Spring Boot

API REST desenvolvida em Java com Spring Boot para gerenciamento de currículos.  
Projeto estruturado seguindo arquitetura em camadas, boas práticas e recursos utilizados em aplicações corporativas.

---

## 🚀 Tecnologias & Stack

- **Java 17**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA / Hibernate**
- **Flyway** (versionamento de banco)
- **MySQL**
- **Docker / Docker Compose**
- **Maven**

---

## 📌 Funcionalidades

- CRUD completo de currículos  
- Arquitetura em camadas: `Controller` → `Service` → `Repository`  
- Migrations automáticas com Flyway  
- Containerização com Docker  
- Padrões de organização usados no mercado

---

## 🗂 Estrutura do Projeto
src/
└── main/java/com/thiago/curriculo
├── controllers
├── domain
├── repositories
└── services
└── resources/db/migration (Flyway)
Dockerfile
docker-compose.yml


---

## ▶️ Como Rodar

### Rodar com Docker
```bash
docker compose up --build


A API estará disponível em:
http://localhost:8080

Rodar localmente
mvn spring-boot:run

📄 Endpoints (exemplo)
GET /curriculos
POST /curriculos
PUT /curriculos/{id}
DELETE /curriculos/{id}

🧑‍💻 Autor

Thiago Espinoza
Desenvolvedor Full Stack
GitHub: https://github.com/thiagolemos23
