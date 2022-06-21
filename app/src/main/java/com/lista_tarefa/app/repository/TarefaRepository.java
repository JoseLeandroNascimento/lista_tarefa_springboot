package com.lista_tarefa.app.repository;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lista_tarefa.app.model.Tarefa;
import com.lista_tarefa.app.model.Usuario;


public interface TarefaRepository extends JpaRepository<Tarefa,Long>{
    
    @Query(" SELECT t FROM Tarefa t LEFT JOIN Usuario u ON t.titulo LIKE %:termoBusca%"
          +" OR t.descricao LIKE %:termoBusca%"
          +" OR u.usuario LIKE %:termoBusca% "
    )
    public List<Tarefa> getTarefasAs(@PathParam("termoBusca") String termoBusca);

    public List<Tarefa> findByUsuario(Usuario usuario);
    
}
