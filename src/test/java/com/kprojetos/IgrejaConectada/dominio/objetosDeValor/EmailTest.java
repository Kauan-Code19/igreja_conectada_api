package com.kprojetos.IgrejaConectada.dominio.objetosDeValor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailTest {
    private static final String FORMATO_INVALIDO = "Formato de e-mail inválido.";

    @Test
    void deveCriarEmailQuandoFormatoForValido() {
        String emailValido = "usuario@example.com";
        Email email = new Email(emailValido);

        assertEquals(emailValido, email.getValor());
    }


    @Test
    void deveLancarExcecaoQuandoFormatoForInvalido() {
        String emailInvalido = "email_invalido@";

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Email(emailInvalido)
        );

        assertEquals(FORMATO_INVALIDO, exception.getMessage());
    }


    @Test
    void emailsComMesmoValorSaoIguais() {
        Email email1 = new Email("teste@exemplo.com");
        Email email2 = new Email("teste@exemplo.com");
        assertEquals(email1, email2);
        assertEquals(email1.hashCode(), email2.hashCode());
    }


    @Test
    void emailsComValoresDiferentesNaoSaoIguais() {
        Email email1 = new Email("teste1@exemplo.com");
        Email email2 = new Email("teste2@exemplo.com");
        assertNotEquals(email1, email2);
    }
}