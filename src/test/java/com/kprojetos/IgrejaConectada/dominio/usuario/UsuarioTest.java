package com.kprojetos.IgrejaConectada.dominio.usuario;

import com.kprojetos.IgrejaConectada.aplicacao.auxiliares.ConversorParaObjetosDeValor;
import com.kprojetos.IgrejaConectada.aplicacao.auxiliares.UsuarioFabrica;
import com.kprojetos.IgrejaConectada.dominio.objetosDeValor.Email;
import com.kprojetos.IgrejaConectada.dominio.objetosDeValor.Nome;
import com.kprojetos.IgrejaConectada.dominio.objetosDeValor.Senha;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UsuarioTest {
    private final String nome = "João Silva";
    private final String email = "joao@email.com";
    private final String senha = "senhaSegura@123";
    private final Nome nomeObjetoValor =  ConversorParaObjetosDeValor.nome(nome);
    private final Email emailObjetoValor =  ConversorParaObjetosDeValor.email(email);
    private final Senha senhaObjetoValor =  ConversorParaObjetosDeValor.senha(senha);

    @Test
    void deveCriarUsuarioComDadosValidos() {
        Usuario usuario = UsuarioFabrica.criar(
                1L,
                nome,
                email,
                senha
        );

        assertEquals(1L, usuario.getId());
        assertEquals(nomeObjetoValor, usuario.getNome());
        assertEquals(emailObjetoValor, usuario.getEmail());
        assertEquals(senhaObjetoValor, usuario.getSenha());
    }
}