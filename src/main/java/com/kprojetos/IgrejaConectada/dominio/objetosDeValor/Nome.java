package com.kprojetos.IgrejaConectada.dominio.objetosDeValor;

import java.util.Objects;

public class Nome {
    private String valor;


    public Nome(String valor) {
        this.valor = valor;
    }


    public String getValor() {
        return valor;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Nome nome = (Nome) o;
        return Objects.equals(valor, nome.valor);
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(valor);
    }
}
