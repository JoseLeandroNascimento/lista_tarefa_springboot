package com.lista_tarefa.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lista_tarefa.app.model.Tarefa;
import com.lista_tarefa.app.repository.TarefaRepository;

@Service
public class TarefaService implements CRUDService<Tarefa>{

    private TarefaRepository tarefaRepository;

    @Autowired
    public TarefaService(TarefaRepository tarefaRepository){

        this.tarefaRepository = tarefaRepository;
    }

    @Override
    public Tarefa getById(Long id) {

        return this.tarefaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Tarefa> getAll() {
        
        return this.tarefaRepository.findAll();
    }

    @Override
    public Tarefa save(Tarefa object) {

        return this.tarefaRepository.save(object);
    }

    @Override
    public void delete(Long id) {
        
        this.tarefaRepository.deleteById(id);
        
    }

    @Override
    public List<Tarefa> findByAll(String termo) {

        return null;
    }
    
}
