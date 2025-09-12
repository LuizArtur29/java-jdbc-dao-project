Projeto JDBC para Acesso a Banco de Dados
Este projeto é uma aplicação Java de console desenvolvida como parte de um curso de acesso a banco de dados com JDBC. O objetivo é demonstrar as operações fundamentais de um CRUD (Create, Read, Update, Delete) utilizando o padrão de projeto DAO (Data Access Object).

A aplicação gerencia duas entidades principais: Seller (Vendedor) e Department (Departamento), com um relacionamento entre elas.

🚀 Tecnologias Utilizadas
Java 11+: Linguagem de programação principal.

JDBC (Java Database Connectivity): API padrão para a conectividade entre a aplicação Java e um banco de dados.

MySQL: Sistema de Gerenciamento de Banco de Dados utilizado.

MySQL Connector/J: Driver JDBC para a comunicação com o banco de dados MySQL.

✨ Funcionalidades
O projeto implementa um CRUD completo para as entidades Seller e Department, incluindo:

Seller (Vendedor)
Inserir um novo vendedor no banco de dados.

Atualizar os dados de um vendedor existente.

Deletar um vendedor pelo seu ID.

Buscar um vendedor específico pelo seu ID.

Listar todos os vendedores cadastrados.

Listar todos os vendedores pertencentes a um determinado departamento.

Department (Departamento)
Inserir um novo departamento.

Atualizar o nome de um departamento existente.

Deletar um departamento pelo seu ID.

Buscar um departamento pelo seu ID.

Listar todos os departamentos.

📁 Estrutura do Projeto
O projeto está organizado em pacotes para separar as responsabilidades, seguindo boas práticas de desenvolvimento:

src
├── application/
│   ├── application.java      # Classe principal para testar o SellerDao
│   └── application2.java     # Classe principal para testar o DepartmentDao
├── db/
│   ├── DB.java               # Classe para gerenciar a conexão com o banco
│   ├── DbException.java      # Exceção personalizada para erros de banco
│   └── DbIntegrityException.java # Exceção para erros de integridade referencial
├── model/
│   ├── dao/
│   │   ├── DaoFactory.java       # Fábrica para criar os objetos DAO
│   │   ├── DepartmentDao.java    # Interface para o DAO de Department
│   │   └── SellerDao.java        # Interface para o DAO de Seller
│   ├── impl/
│   │   ├── DepartmentDaoJDBC.java # Implementação do DAO para Department
│   │   └── SellerDaoJDBC.java     # Implementação do DAO para Seller
│   └── entities/
│       ├── Department.java       # Entidade que representa um Departamento
│       └── Seller.java           # Entidade que representa um Vendedor
⚙️ Configuração e Execução
Pré-requisitos
Java JDK 11 ou superior.

MySQL Server instalado e rodando.

Uma IDE Java (Eclipse, IntelliJ, VSCode, etc.).

O driver MySQL Connector/J.

Passos para Execução
Banco de Dados:

Crie um banco de dados no seu MySQL chamado coursejdbc.

Execute o script SQL abaixo para criar as tabelas department e seller e popular com dados iniciais.

SQL

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
Configuração da Conexão:

Na raiz do projeto, localize o arquivo db.properties.

Altere as propriedades user e password para corresponder às suas credenciais do MySQL.

Properties

user=seu_usuario_mysql
password=sua_senha_mysql
dburl=jdbc:mysql://localhost:3306/coursejdbc
Execução:

Compile e execute as classes application.java e application2.java para ver os testes de cada DAO em ação.

O resultado das operações será exibido no console.
