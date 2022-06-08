package com.lista_tarefa.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lista_tarefa.app.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    
}
