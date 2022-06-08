SET SESSION FOREIGN_KEY_CHECKS=0;

CREATE TABLE usuario (

    id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome varchar(100) NOT NULL,
    usuario varchar(100) NOT NULL,
    senha varchar(10) NOT NULL

);

CREATE TABLE tarefa (
        
        id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
        titulo varchar(100),
        descricao text,
        status_tarefa int,
        usuario_id int REFERENCES usuario (id),
        prioridade int
    );
