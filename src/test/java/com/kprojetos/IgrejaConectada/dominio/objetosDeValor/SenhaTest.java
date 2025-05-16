package com.kprojetos.IgrejaConectada.dominio.objetosDeValor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SenhaTest {
    private static final String REGRAS_SENHA =
            "A senha deve ter pelo menos 8 caracteres, " +
            "incluindo uma letra maiúscula, " +
            "uma letra minúscula, um número e um caractere especial (@#$%^&+=!).";

    @Test
    void deveCriarSenhaQuandoFormatoForValido() {
        String senhaValida = "senhaSegura@123";
        Senha senha = new Senha(senhaValida);

        assertEquals(senhaValida, senha.getValor());
    }


    @Test
    void deveLancarExcecaoQuandoFormatoForInvalido() {
        String senhaInvalida = "senhaSegura123";

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Senha(senhaInvalida)
        );

        assertEquals(REGRAS_SENHA, exception.getMessage());
    }


    @Test
    void emailsComMesmoValorSaoIguais() {
        Senha senha1 = new Senha("senhaSegura@123");
        Senha senha2 = new Senha("senhaSegura@123");
        assertEquals(senha1, senha2);
        assertEquals(senha1.hashCode(), senha2.hashCode());
    }


    @Test
    void emailsComValoresDiferentesNaoSaoIguais() {
        Senha senha1 = new Senha("tsenhaSegura@123");
        Senha senha2 = new Senha("senhaSegura@1234");
        assertNotEquals(senha1, senha2);
    }
}