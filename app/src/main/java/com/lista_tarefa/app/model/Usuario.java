package com.lista_tarefa.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(
    columnNames = {"usuario","email","nome"}
)})
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String usuario;
    
    @JsonIgnore
    private String senha;

    private String email;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Tarefa> tarefas;
    
    public List<Tarefa> getTarefas() {
        return tarefas;
    }
    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
}
