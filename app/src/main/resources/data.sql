SET SESSION FOREIGN_KEY_CHECKS=0;

CREATE TABLE usuario (

    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome varchar(100)

);

CREATE TABLE tarefa (
        
        id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
        titulo varchar(100),
        descricao text,
        status_tarefa int,
        usuario_id int REFERENCES usuario (id), -- Valor está vindo nulo
        prioridade int
    );

INSERT INTO usuario (nome) VALUES ('Fulana');
INSERT INTO tarefa (titulo, descricao, status_tarefa, prioridade) values ('compras', 'fazer compras', '2', '10');