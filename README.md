# HOSPITECH 🏥
# Sumário  
[Introdução](#introdução)  
[Funcionalidades](#funcionalidades)  
[Como Rodar a Aplicação](#como-rodar-a-aplicação)  
[Documentação da API (Swagger)](#documentação-da-api-swagger)  
[Docker Compose](#docker-compose)   
[Diagramas](#diagramas)  


# Introdução

## Sobre o Projeto

Este projeto foi desenvolvido como parte do Tech Challenge da FIAP no curso de Pós-Tech, com foco na criação de uma API RESTful para a gestão de agendamentos hospitalares, denominada HospiTech Appointment Service.

O objetivo principal é oferecer uma solução robusta, segura e escalável, que possibilite o gerenciamento eficiente de usuários, consultas e dados relacionados ao ambiente hospitalar. O projeto foi estruturado com base em boas práticas de desenvolvimento, priorizando qualidade de código, documentação e integração com serviços modernos.

# Funcionalidades

A API HospiTech Appointment Service oferece as seguintes funcionalidades:

- **Gerenciamento de Usuários**  
  - Criar, listar, atualizar e deletar usuários  
  - Validação de login 

- **Documentação Automática com Swagger**  
  - Integração com o **Springdoc OpenAPI** para exibição interativa de todos os endpoints disponíveis da API.

- **Integração com Docker Compose**  
  - Inclui imagens do **MySQL**, **RabbitMQ** e **da própria aplicação**, permitindo a execução completa do sistema sem necessidade de abrir a IDE.

# Como Rodar a Aplicação

## Pré-requisitos

- Java 21 (caso deseje rodar fora do Docker)  
- Maven  
- Docker e Docker Compose

## Passos para Execução

### 1. Clonar o Projeto

Clone o repositório na branch `main`:
```bash
git clone -b main https://github.com/postech-fiap-group/hospitech-appointment-service
```
### 2. Executar com Docker Compose

No terminal, dentro da pasta raiz do projeto, execute:

```bash
docker compose up -d
```

Este comando iniciará os seguintes containers:
- **MySQL**
- **RabbitMQ**
- **Aplicação Java (HospiTech)**

### 3. Acessar a API

Se estiver rodando a aplicação localmente pela IDE, utilize a porta 8083:

[http://localhost:8083/swagger-ui/index.html#/](http://localhost:8081/swagger-ui/index.html#/)

# Documentação da API (Swagger)

A documentação da API é gerada automaticamente utilizando o **Springdoc OpenAPI**, acessível através da URL acima. Nela você poderá testar os endpoints diretamente pelo navegador, facilitando o desenvolvimento e testes.

# Docker Compose

O projeto utiliza Docker Compose com os seguintes serviços:

- **MySQL**: Banco de dados relacional para persistência dos dados.  
- **RabbitMQ**: Preparado para funcionalidades de mensageria futura.

O `Dockerfile` está configurado com:

- **Java 21**  
- **Maven**     

# Diagramas

## Diagrama UML
![model.png](documentacao/diagrama-classes/model.jpg)

## Diagrama de Arquitetura
![arquitetura.png](documentacao/diagrama-classes/arquitetura.png)
