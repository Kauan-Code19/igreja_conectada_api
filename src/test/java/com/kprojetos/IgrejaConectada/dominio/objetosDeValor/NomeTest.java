package com.kprojetos.IgrejaConectada.dominio.objetosDeValor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class NomeTest {

    @Test
    void deveCriarNomeQuandoFormatoForValido() {
        String nomeValido = "João Silva";
        Nome nome = new Nome(nomeValido);

        assertEquals(nomeValido, nome.getValor());
    }


    @Test
    void nomesComMesmoValorSaoIguais() {
        Nome nome1 = new Nome("João Silva");
        Nome nome2 = new Nome("João Silva");

        assertEquals(nome1, nome2);
        assertEquals(nome1.hashCode(), nome2.hashCode());
    }


    @Test
    void emailsComValoresDiferentesNaoSaoIguais() {
        Nome nome1 = new Nome("João Silva");
        Nome nome2 = new Nome("João");

        assertNotEquals(nome1, nome2);
    }
}