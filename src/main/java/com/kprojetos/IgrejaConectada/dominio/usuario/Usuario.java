package com.kprojetos.IgrejaConectada.dominio.usuario;

import com.kprojetos.IgrejaConectada.dominio.objetosDeValor.Email;
import com.kprojetos.IgrejaConectada.dominio.objetosDeValor.Nome;
import com.kprojetos.IgrejaConectada.dominio.objetosDeValor.Senha;

public class Usuario {
    private Long id;
    private Nome nome;
    private Email email;
    private Senha senha;


    public Usuario(
            Long id,
            Nome nome,
            Email email,
            Senha senha
    ) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }


    public Long getId() {
        return id;
    }

    public Nome getNome() {
        return nome;
    }

    public Email getEmail() {
        return email;
    }

    public Senha getSenha() {
        return senha;
    }
}
