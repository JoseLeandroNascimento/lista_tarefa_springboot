package com.lista_tarefa.app.service;

import java.util.List;

public interface CRUDService <T>{
    
    public T getById(Long id);
    
    public List<T> getAll();

    public T save(T object);

    public void delete(Long id);
    
}
