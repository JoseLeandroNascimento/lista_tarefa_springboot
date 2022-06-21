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

import com.lista_tarefa.app.model.Usuario;
import com.lista_tarefa.app.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController implements CRUDController<Usuario>{

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService){

        this.usuarioService = usuarioService;
    }

    
    
    @Override
    @GetMapping("/")
    public ResponseEntity<List<Usuario>> getAll() {
        
        List<Usuario> usuarios = usuarioService.getAll();

        return new ResponseEntity<>(usuarios,HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") Long id) {
        
        Usuario registro = this.usuarioService.getById(id);

        if(registro == null){

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(registro,HttpStatus.OK);
    }

    @Override
    @GetMapping("/filtrar/{termoBusca}")
    public ResponseEntity<List<Usuario>> getByAll(@PathVariable("termoBusca") String termoBusca) {
        
        List<Usuario> registros = this.usuarioService.findByAll(termoBusca);

        return new ResponseEntity<>(registros,HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Usuario> insert(@RequestBody Usuario object) {
        
        Usuario registro = this.usuarioService.save(object);

        return new ResponseEntity<>(registro,HttpStatus.CREATED);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<Usuario> update(@RequestBody Usuario object) {
        
        Usuario registro = this.usuarioService.save(object);

        return new ResponseEntity<>(registro,HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {

        this.usuarioService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    
}
