# Projeto JDBC: Acesso a Banco de Dados com Padrão DAO

Este projeto é uma aplicação Java de console desenvolvida para demonstrar as operações fundamentais de um CRUD (Create, Read, Update, Delete) utilizando **JDBC** e o padrão de projeto **DAO (Data Access Object)**. A aplicação gerencia as entidades `Seller` (Vendedor) e `Department` (Departamento) em um banco de dados MySQL.

---

## 🚀 Tecnologias Utilizadas

- **Java 11+**
- **JDBC (Java Database Connectivity)**
- **MySQL 8.0+**
- **MySQL Connector/J** (Driver JDBC)

---

## ✨ Funcionalidades

O projeto implementa um CRUD completo para as entidades `Seller` e `Department`, permitindo:

#### Vendedores (`Seller`)
- ✔️ Inserir um novo vendedor.
- ✔️ Atualizar os dados de um vendedor existente.
- ✔️ Deletar um vendedor pelo seu ID.
- ✔️ Buscar um vendedor específico pelo seu ID.
- ✔️ Listar todos os vendedores.
- ✔️ Listar todos os vendedores de um determinado departamento.

#### Departamentos (`Department`)
- ✔️ Inserir um novo departamento.
- ✔️ Atualizar o nome de um departamento.
- ✔️ Deletar um departamento pelo seu ID.
- ✔️ Buscar um departamento pelo seu ID.
- ✔️ Listar todos os departamentos.

---

## 📁 Estrutura do Projeto

O código-fonte está organizado em pacotes para separar as responsabilidades e manter o código limpo e organizado.

```
src
├── application/
│   ├── application.java      # Classe principal para testar o SellerDao
│   └── application2.java     # Classe principal para testar o DepartmentDao
├── db/
│   ├── DB.java               # Classe utilitária para conexão com o banco
│   ├── DbException.java      # Exceção personalizada para erros de banco
│   └── DbIntegrityException.java # Exceção para erros de integridade referencial
├── model/
│   ├── dao/
│   │   ├── DaoFactory.java       # Fábrica para instanciar os objetos DAO
│   │   ├── DepartmentDao.java    # Interface do DAO para Department
│   │   └── SellerDao.java        # Interface do DAO para Seller
│   ├── impl/
│   │   ├── DepartmentDaoJDBC.java # Implementação JDBC do DAO para Department
│   │   └── SellerDaoJDBC.java     # Implementação JDBC do DAO para Seller
│   └── entities/
│       ├── Department.java       # Entidade de domínio Department
│       └── Seller.java           # Entidade de domínio Seller
```

---

## ⚙️ Configuração e Execução

Siga os passos abaixo para configurar e executar o projeto em sua máquina local.

### Pré-requisitos

- **Java JDK 11** ou superior.
- **MySQL Server 8.0** ou superior.
- Uma IDE Java, como IntelliJ IDEA, Eclipse ou VSCode.
- O driver **MySQL Connector/J** adicionado às bibliotecas do projeto.

### 1. Configuração do Banco de Dados

Primeiro, crie o banco de dados e as tabelas necessárias.

- **Crie o Schema**: Conecte-se ao seu MySQL e execute o comando:
  ```sql
  CREATE DATABASE coursejdbc;
  USE coursejdbc;
  ```

- **Crie as Tabelas e Insira os Dados**: Execute o script SQL abaixo para criar as tabelas `department` e `seller` e populá-las com dados iniciais.
  ```sql
  CREATE TABLE department (
    Id int(11) NOT NULL AUTO_INCREMENT,
    Name varchar(60) DEFAULT NULL,
    PRIMARY KEY (Id)
  );

  CREATE TABLE seller (
    Id int(11) NOT NULL AUTO_INCREMENT,
    Name varchar(60) NOT NULL,
    Email varchar(100) NOT NULL,
    BirthDate datetime NOT NULL,
    BaseSalary double NOT NULL,
    DepartmentId int(11) NOT NULL,
    PRIMARY KEY (Id),
    FOREIGN KEY (DepartmentId) REFERENCES department (id)
  );

  INSERT INTO department (Name) VALUES
    ('Computers'),
    ('Electronics'),
    ('Fashion'),
    ('Books');

  INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES
    ('Bob Brown','bob@gmail.com','1998-04-21 00:00:00',1000,1),
    ('Maria Green','maria@gmail.com','1979-12-31 00:00:00',3500,2),
    ('Alex Grey','alex@gmail.com','1988-01-15 00:00:00',2200,1),
    ('Martha Red','martha@gmail.com','1993-11-30 00:00:00',3000,4),
    ('Donald Blue','donald@gmail.com','2000-01-09 00:00:00',4000,3),
    ('Alex Pink','bob@gmail.com','1997-03-04 00:00:00',3000,2);
  ```

### 2. Configuração da Conexão

Na raiz do projeto, edite o arquivo `db.properties` com as suas credenciais de acesso ao MySQL.

```properties
user=SEU_USUARIO_MYSQL
password=SUA_SENHA_MYSQL
dburl=jdbc:mysql://localhost:3306/coursejdbc?useSSL=false&serverTimezone=UTC
```
*Observação: O parâmetro `serverTimezone=UTC` pode ser necessário para evitar erros de fuso horário.*

### 3. Execução da Aplicação

O projeto contém duas classes `main` para testar os DAOs:

- Para testar as funcionalidades de `Seller`, execute o arquivo `application.java`.
- Para testar as funcionalidades de `Department`, execute o arquivo `application2.java`.

O resultado de cada operação de teste será impresso no console.

---
