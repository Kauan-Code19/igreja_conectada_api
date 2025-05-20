package com.kprojetos.IgrejaConectada.infraestrutura.usuario;


import com.kprojetos.IgrejaConectada.aplicacao.usuario.auxiliares.UsuarioFabrica;
import com.kprojetos.IgrejaConectada.dominio.usuario.Usuario;
import com.kprojetos.IgrejaConectada.dominio.usuario.UsuarioTipo;
import com.kprojetos.IgrejaConectada.infraestrutura.usuario.auxiliares.UsuarioEntidadeFabrica;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UsuarioEntidadeTest {
    private final String nome = "João Silva";
    private final String email = "joao@email.com";
    private final String senha = "senhaSegura@123";
    private final Usuario usuario = UsuarioFabrica.criar(
            1L,
            nome,
            email,
            senha,
            UsuarioTipo.ADMINISTRADOR
    );

    @Test
    void deveCriarUsuarioEntidadeComDadosValidos() {
        UsuarioEntidade usuarioEntidade = UsuarioEntidadeFabrica.criar(usuario);

        assertEquals(1L, usuarioEntidade.getId());
        assertEquals(nome, usuarioEntidade.getNome());
        assertEquals(email, usuarioEntidade.getEmail());
        assertEquals(senha, usuarioEntidade.getSenha());
    }
}