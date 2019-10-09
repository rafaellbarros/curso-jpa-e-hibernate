-- DDL (Data Definition Language ou LInguagem de Definição de Dados) --
CREATE TABLE cliente (
	codigo  BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    idade INTEGER,
    sexo VARCHAR(1) NOT NULL,
    profissao VARCHAR(30),
    PRIMARY KEY(codigo)
);

-- DML (Data Manipulation Language, ou Linguagem de Manipulação de Dados) --
INSERT INTO cliente (nome, idade, sexo, profissao) VALUES ("José da Silva", 25,"M", "Engenheiro de Software");
INSERT INTO cliente (nome, idade, sexo, profissao) VALUES ("Maria Rita", 22,"F", "Designer UX");

-- DQL (Data Query Language ou LInguagem de Consulta de Dados) --
SELECT * FROM cliente;

-- DDL --
CREATE TABLE conta_corrente (
	codigo BIGINT NOT NULL AUTO_INCREMENT,
    numero VARCHAR(12) NOT NULL,
    saldo DECIMAL,
    codigo_cliente BIGINT NOT NULL,
    PRIMARY KEY(codigo),
    FOREIGN KEY(codigo_cliente) REFERENCES cliente (codigo)
);

-- DML --
INSERT INTO conta_corrente (numero, saldo, codigo_cliente) VALUES (11111, 8500.00, 1);
INSERT INTO conta_corrente (numero, saldo, codigo_cliente) VALUES (22222, 5000.00, 2);

-- DQL --
SELECT * FROM conta_corrente;

-- DQL --
SELECT cli.nome
	, cc.saldo
    FROM cliente cli
    , conta_corrente cc
    WHERE cli.codigo = cc.codigo_cliente;


