package com.kprojetos.IgrejaConectada.aplicacao.usuario.dtos;

import com.kprojetos.IgrejaConectada.dominio.usuario.UsuarioTipo;

public record CriarUsuarioDTO(
        String nome,
        String email,
        String senha,
        UsuarioTipo tipo
) {
}
