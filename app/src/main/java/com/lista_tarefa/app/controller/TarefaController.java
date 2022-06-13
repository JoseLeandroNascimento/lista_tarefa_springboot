package com.lista_tarefa.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lista_tarefa.app.model.Tarefa;
import com.lista_tarefa.app.service.TarefaService;

@RestController
@RequestMapping("/tarefa")
public class TarefaController implements CRUDController<Tarefa> {

    private TarefaService tarefaService;

    @Autowired
    public TarefaController(TarefaService tarefaService){

        this.tarefaService = tarefaService;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<Tarefa>> getAll() {

        List<Tarefa> registros = this.tarefaService.getAll();

        return new ResponseEntity<>(registros,HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> getById(@PathVariable("id") Long id) {

        Tarefa registro = this.tarefaService.getById(id);

        return new ResponseEntity<>(registro,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Tarefa>> getByAll(String termoBusca) {

        return null;
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Tarefa> insert(@RequestBody Tarefa object) {

        Tarefa registro = this.tarefaService.save(object);

        return new ResponseEntity<>(registro,HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<Tarefa> update(Tarefa object) {

        Tarefa registro = this.tarefaService.save(object);

        return new ResponseEntity<>(registro,HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {

        this.tarefaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
