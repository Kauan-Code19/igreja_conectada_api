package com.kprojetos.IgrejaConectada.dominio.objetosDeValor;

import java.util.Objects;
import java.util.regex.Pattern;

public class Email {
    private String valor;
    private static final Pattern PADRAO_EMAIL = Pattern.compile(
            "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9]" +
                    "(?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?" +
                    "(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$"
    );
    private static final String FORMATO_INVALIDO = "Formato de e-mail inválido.";


    public Email(String valor) {
        validarFormato(valor);
        this.valor = valor;
    }


    private void validarFormato(String valor) {
        if (!PADRAO_EMAIL.matcher(valor).matches()) {
            throw new IllegalArgumentException(
                    FORMATO_INVALIDO
            );
        }
    }


    public String getValor() {
        return valor;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(valor, email.valor);
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(valor);
    }
}
