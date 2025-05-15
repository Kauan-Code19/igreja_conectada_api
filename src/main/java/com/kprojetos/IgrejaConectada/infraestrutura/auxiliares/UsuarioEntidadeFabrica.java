package com.kprojetos.IgrejaConectada.infraestrutura.auxiliares;

import com.kprojetos.IgrejaConectada.dominio.usuario.Usuario;
import com.kprojetos.IgrejaConectada.infraestrutura.usuario.UsuarioEntidade;

public final class UsuarioEntidadeFabrica {
    private UsuarioEntidadeFabrica() {}

    public static UsuarioEntidade criar(Usuario usuario) {
        return new UsuarioEntidade(
                usuario.getId(),
                usuario.getNome().getValor(),
                usuario.getEmail().getValor(),
                usuario.getSenha().getValor()
        );
    }
}

