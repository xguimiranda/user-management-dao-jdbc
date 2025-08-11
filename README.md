# user-management-dao-jdbc 💻🗃️

Projeto desenvolvido como parte do curso de Programação Orientada a Objetos em Java (Prof. Nelio Alves – Udemy). Objetivo: demonstrar na prática a implementação do padrão **DAO (Data Access Object)** usando JDBC, aplicando separação de responsabilidades e operações CRUD.

## 📄 Descrição

O projeto **user-management-dao-jdbc** é uma aplicação de exemplo que mostra conceitos essenciais de POO em Java juntamente com o uso do padrão DAO para separar a lógica de acesso a dados da lógica de negócio.  
Serve como base de estudo para quem deseja consolidar:

- 👨‍💻 Programação Orientada a Objetos em Java  
- 🗄️ Integração com banco de dados via JDBC  
- 📚 Implementação do padrão DAO  
- 📝 Operações CRUD com JDBC  
- 🏗️ Estruturação limpa de projetos Java  

## 🚀 Funcionalidades

- Cadastrar, consultar, atualizar e remover registros no banco
- Separação clara entre camada de acesso a dados (DAO) e camada de serviço/negócio
- Exemplos práticos do uso de JDBC (PreparedStatement, ResultSet, conexões)

## 🛠️ Tecnologias Utilizadas

- Java (versão recomendada: 11 ou 17)  
- JDBC (Java Database Connectivity)  
- Banco Relacional (exemplo: MySQL)  
- IDE de sua preferência (Eclipse / IntelliJ / VS Code)  
- Driver JDBC do MySQL (ex.: mysql-connector-j)  

## 🏁 Como Executar

1. Clonar o repositório:
   ```bash
   git clone https://github.com/xguimiranda/user-management-dao-jdbc.git
   cd user-management-dao-jdbc
   ```
2. Importar o projeto na sua IDE favorita.  
3. Configurar as credenciais do banco (URL, usuário e senha) no arquivo de configuração (ex.: `db.properties` ou dentro da classe util, conforme implementação).  
4. Criar o schema/tabelas usando o script SQL abaixo.  
5. Executar a classe principal / testes de DAO.  

> Certifique-se de que o banco MySQL está ativo e acessível.

## 🗂️ Estrutura de Banco (MySQL)

```sql
CREATE TABLE department (
  Id INT NOT NULL AUTO_INCREMENT,
  Name VARCHAR(60) DEFAULT NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE seller (
  Id INT NOT NULL AUTO_INCREMENT,
  Name VARCHAR(60) NOT NULL,
  Email VARCHAR(100) NOT NULL,
  BirthDate DATETIME NOT NULL,
  BaseSalary DOUBLE NOT NULL,
  DepartmentId INT NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (DepartmentId) REFERENCES department (Id)
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
  ('Alex Pink','alex.pink@gmail.com','1997-03-04 00:00:00',3000,2);
```

(Se quiser manter exatamente como no curso, deixe o e-mail duplicado.)

## 🧪 Possíveis Testes

- Inserção de novo vendedor  
- Atualização de salário  
- Busca por departamento  
- Remoção com validação de chave estrangeira  

## 🔧 Estrutura Conceitual (diretórios típicos)

```
src/
 ├── application/        # Programa principal / testes
 ├── db/                 # Utilidades de conexão (DB, exceptions)
 ├── model/
 │    ├── entities/      # Entidades (Seller, Department)
 │    ├── dao/           # Interfaces DAO
 │    └── dao/impl/      # Implementações JDBC
 └── resources/          # Arquivos de configuração (se aplicável)
```

## 👏🏻 Créditos

Projeto baseado no curso [Java COMPLETO Programação Orientada a Objetos + Projetos](https://www.udemy.com/course/java-curso-completo/) do Prof. Nelio Alves (Udemy).

---

Sinta-se à vontade para usar este projeto como base para estudos ou evoluções! 🚀
