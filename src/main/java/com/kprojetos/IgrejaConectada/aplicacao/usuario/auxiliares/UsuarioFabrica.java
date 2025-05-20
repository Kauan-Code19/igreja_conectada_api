package com.kprojetos.IgrejaConectada.aplicacao.usuario.auxiliares;

import com.kprojetos.IgrejaConectada.aplicacao.ConversorParaObjetosDeValor;
import com.kprojetos.IgrejaConectada.aplicacao.usuario.dtos.CriarUsuarioDTO;
import com.kprojetos.IgrejaConectada.dominio.usuario.Usuario;
import com.kprojetos.IgrejaConectada.dominio.usuario.UsuarioTipo;

public final class UsuarioFabrica {
    private UsuarioFabrica() {}

    public static Usuario criar(CriarUsuarioDTO dto) {
        return new Usuario(
                null,
                ConversorParaObjetosDeValor.nome(dto.nome()),
                ConversorParaObjetosDeValor.email(dto.email()),
                ConversorParaObjetosDeValor.senha(dto.senha()),
                dto.tipo()
        );
    }


    public static Usuario criar(
            Long id,
            String nome,
            String email,
            String senha,
            UsuarioTipo tipo
    ) {
        return new Usuario(
                id,
                ConversorParaObjetosDeValor.nome(nome),
                ConversorParaObjetosDeValor.email(email),
                ConversorParaObjetosDeValor.senha(senha),
                tipo
        );
    }
}
