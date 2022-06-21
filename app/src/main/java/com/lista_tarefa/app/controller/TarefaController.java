package com.lista_tarefa.app.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.lista_tarefa.app.model.Usuario;
import com.lista_tarefa.app.service.TarefaService;
import com.lista_tarefa.app.service.UsuarioService;

@RestController
@RequestMapping("/tarefa")
public class TarefaController implements CRUDController<Tarefa> {

    private TarefaService tarefaService;
    private UsuarioService usuarioService;
    
    public TarefaController(TarefaService tarefaService,UsuarioService usuarioService){

        this.tarefaService = tarefaService;
        this.usuarioService = usuarioService;
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

        if( registro == null){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(registro,HttpStatus.OK);
    }

    @Override
    @GetMapping("/filtrar/{termoBusca}")
    public ResponseEntity<List<Tarefa>> getByAll(@PathVariable("termoBusca") String termoBusca) {

        List<Tarefa> registros = this.tarefaService.findByAll(termoBusca);

        return new ResponseEntity<>(registros,HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Tarefa> insert(@RequestBody @Valid Tarefa object) {

        if(this.usuarioService.getById(object.getUsuario().getId()) != null){

            Tarefa registro = this.tarefaService.save(object);

            return new ResponseEntity<>(registro,HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<Tarefa> update(@RequestBody Tarefa object) {

        Long id_tarefa = object.getId();
        if( id_tarefa != null && this.tarefaService.getById(id_tarefa) != null &&
            this.usuarioService.getById(object.getUsuario().getId()) != null
        ){

            Tarefa registro = this.tarefaService.save(object);
            return new ResponseEntity<>(registro,HttpStatus.OK);
            
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {

        this.tarefaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/usuario/{id_usuario}")
    public ResponseEntity<List<Tarefa>> getTarefaByUsuario(@PathVariable("id_usuario") Long id_usuario){

        Usuario usuario = this.usuarioService.getById(id_usuario);

        if(usuario != null){

            List<Tarefa> tarefas = this.tarefaService.findByUsuario(usuario);

            return new ResponseEntity<>(tarefas,HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
