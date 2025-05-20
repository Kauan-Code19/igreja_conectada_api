package com.kprojetos.IgrejaConectada.aplicacao.usuario.auxiliares;

import com.kprojetos.IgrejaConectada.aplicacao.usuario.dtos.UsuarioRespostaDTO;
import com.kprojetos.IgrejaConectada.dominio.usuario.Usuario;

public final class UsuarioMapeador {
    private UsuarioMapeador() {}


    public static UsuarioRespostaDTO paraUsuarioRespostaDTO(Usuario usuario) {
        return new UsuarioRespostaDTO(
                usuario.getId(),
                usuario.getNome().getValor(),
                usuario.getEmail().getValor(),
                usuario.getTipo()
        );
    }
}
