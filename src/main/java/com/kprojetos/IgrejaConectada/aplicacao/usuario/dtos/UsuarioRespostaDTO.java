package com.kprojetos.IgrejaConectada.aplicacao.usuario.dtos;

import com.kprojetos.IgrejaConectada.dominio.usuario.UsuarioTipo;

public record UsuarioRespostaDTO(
        Long id,
        String nome,
        String email,
        UsuarioTipo tipo
) {
}
