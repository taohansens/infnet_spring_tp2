# API de Produtos

Este projeto é uma API RESTful para gerenciamento de produtos, permitindo operações CRUD (Create, Read, Update, Delete) sobre uma lista de produtos em memória.

## Tecnologias Utilizadas

- Spring Boot
- Java

## Configuração do Ambiente

Para executar este projeto, você precisará ter o Java e o Maven instalados em sua máquina. As versões recomendadas são:

- Java 21 ou superior
- Maven 3.6 ou superior

## Como Executar

Siga os passos abaixo para executar o projeto localmente:

### 1. Clone o Repositório

Clone o código fonte do repositório Git para sua máquina local usando:

```bash
git clone
cd produtos-api
mvn clean install
```
Após a construção, você pode executar a aplicação usando:
```
mvn spring-boot:run
```

### 2. Acesse a API

As operações disponíveis são:

- POST /produtos: Adiciona um novo produto
```
Payload:
    "name": string,
    "description": string,
    "price": double,
    "category": {
        "id": int,
        "name": string
    }
```
- GET /produtos: Lista todos os produtos
- GET /produtos/{id}: Retorna um produto pelo ID
- PUT /produtos/{id}: Atualiza um produto existente pelo ID
- DELETE /produtos/{id}: Remove um produto pelo ID


