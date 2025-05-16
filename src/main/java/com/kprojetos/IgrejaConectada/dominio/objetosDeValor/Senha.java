package com.kprojetos.IgrejaConectada.dominio.objetosDeValor;

import java.util.Objects;

public class Senha {
    private String valor;
    private static final String REGRAS_SENHA =
            "A senha deve ter pelo menos 8 caracteres, " +
            "incluindo uma letra maiúscula, " +
            "uma letra minúscula, um número e um caractere especial (@#$%^&+=!).";
    private static final String REGEX_SENHA =
            "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=." +
            "*[@#$%^&+=!]).{8,}$";


    public Senha(String valor) {
        validarFormato(valor);
        this.valor = valor;
    }


    private void validarFormato(String valor) {
        if (!valor.matches(REGEX_SENHA)) {
            throw new IllegalArgumentException(REGRAS_SENHA);
        }
    }


    public String getValor() {
        return valor;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Senha senha = (Senha) o;
        return Objects.equals(valor, senha.valor);
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(valor);
    }
}
