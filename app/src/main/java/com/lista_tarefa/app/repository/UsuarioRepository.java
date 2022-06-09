package com.lista_tarefa.app.repository;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lista_tarefa.app.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    
    @Query("SELECT u FROM usuario u WHERE u.nome LIKE :termoBusca OR u.usuario LIKE :termoBusca OR u.email LIKE :termoBusca ")
    public List<Usuario> findByAll(@PathParam("termoBusca") String termoBusca);
}
