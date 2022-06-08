package com.lista_tarefa.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lista_tarefa.app.model.Usuario;
import com.lista_tarefa.app.repository.UsuarioRepository;

@Service
public class UsuarioService implements CRUDService<Usuario>{

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){

        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario getById(Long id) {
        
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> getAll() {
   
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario save(Usuario object) {

        return usuarioRepository.save(object);
    }

    @Override
    public void delete(Long id) {

        this.usuarioRepository.deleteById(id);
    }
    
}
