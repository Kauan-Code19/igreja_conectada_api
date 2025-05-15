package com.kprojetos.IgrejaConectada.aplicacao.auxiliares;

import com.kprojetos.IgrejaConectada.dominio.objetosDeValor.Email;
import com.kprojetos.IgrejaConectada.dominio.objetosDeValor.Nome;
import com.kprojetos.IgrejaConectada.dominio.objetosDeValor.Senha;

public final class ConversorParaObjetosDeValor {
    private ConversorParaObjetosDeValor() {}


    public static Nome nome(String valor) {
        return new Nome(valor);
    }


    public static Email email(String valor) {
        return new Email(valor);
    }


    public static Senha senha(String valor) {
        return new Senha(valor);
    }
}
