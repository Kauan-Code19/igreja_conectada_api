package com.kprojetos.IgrejaConectada.aplicacao.auxiliares;

import com.kprojetos.IgrejaConectada.aplicacao.usuario.dtos.CriarUsuarioDTO;
import com.kprojetos.IgrejaConectada.dominio.usuario.Usuario;

public final class UsuarioFabrica {
    private UsuarioFabrica() {}

    public static Usuario criar(CriarUsuarioDTO dto) {
        return new Usuario(
                null,
                ConversorParaObjetosDeValor.nome(dto.nome()),
                ConversorParaObjetosDeValor.email(dto.email()),
                ConversorParaObjetosDeValor.senha(dto.senha())
        );
    }


    public static Usuario criar(
            Long id,
            String nome,
            String email,
            String senha
    ) {
        return new Usuario(
                id,
                ConversorParaObjetosDeValor.nome(nome),
                ConversorParaObjetosDeValor.email(email),
                ConversorParaObjetosDeValor.senha(senha)
        );
    }
}
