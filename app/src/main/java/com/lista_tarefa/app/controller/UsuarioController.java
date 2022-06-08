package com.lista_tarefa.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lista_tarefa.app.model.Usuario;
import com.lista_tarefa.app.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService){

        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Usuario>> usuarios(){

        List<Usuario> usuarios = usuarioService.getAll();

        return new ResponseEntity<>(usuarios,HttpStatus.OK);
    }
    
}
