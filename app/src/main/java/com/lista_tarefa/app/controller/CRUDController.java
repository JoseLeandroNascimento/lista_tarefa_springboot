package com.lista_tarefa.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface CRUDController <T>{
    
    public ResponseEntity<List<T>> getAll();

    public ResponseEntity<T> getById(Long id);

    public ResponseEntity<List<T>> getByAll(String termoBusca);

    public ResponseEntity<T> insert(T object);

    public ResponseEntity<T> update(T object);

    public ResponseEntity<?> delete(Long id);
}
