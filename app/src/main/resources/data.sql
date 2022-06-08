

create table usuario (

    id int primary key auto_increment not null,
    nome varchar(100) not null,
    user varchar(100) not null,
    senha varchar(10) not null,

)

create table tarefa (
        
        id int not null primary key auto_increment,
        titulo varchar(100) not null,
        descricao text,
        status_tarefa int,
        usuario_id int reference usuario (id),
        prioridade int

        );