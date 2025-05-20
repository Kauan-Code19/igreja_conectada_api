package com.kprojetos.IgrejaConectada.dominio.usuario;

import lombok.Getter;

public enum UsuarioTipo {
    ADMINISTRADOR("administrador"),
    COMUM("comum");

    @Getter
    private final String tipo;

    UsuarioTipo(String tipo) {
        this.tipo = tipo;
    }
}
