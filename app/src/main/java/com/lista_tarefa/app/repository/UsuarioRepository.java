package com.lista_tarefa.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lista_tarefa.app.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    
    @Query("SELECT u FROM Usuario u WHERE u.nome LIKE %:termoBusca% OR u.usuario LIKE %:termoBusca% OR u.email LIKE %:termoBusca% ")
    List<Usuario> findByAll(@Param("termoBusca") String termoBusca);
}
