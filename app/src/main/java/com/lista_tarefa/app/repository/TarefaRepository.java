package com.lista_tarefa.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lista_tarefa.app.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa,Long>{
    
    
}
