package com.kprojetos.IgrejaConectada.infraestrutura.usuario;

import com.kprojetos.IgrejaConectada.aplicacao.auxiliares.ConversorParaObjetosDeValor;
import com.kprojetos.IgrejaConectada.aplicacao.auxiliares.UsuarioFabrica;
import com.kprojetos.IgrejaConectada.dominio.usuario.Usuario;
import com.kprojetos.IgrejaConectada.dominio.usuario.UsuarioRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class UsuarioRepositorioImplTest {
    private Usuario usuarioSalvo;
    private final String nome = "João Silva";
    private final String email = "joao@email.com";
    private final String senha = "senhaSegura@123";
    private final Usuario usuario = UsuarioFabrica.criar(
            null,
            nome,
            email,
            senha
    );

    @Autowired
    private UsuarioRepositorio repositorio;


    @BeforeEach
    void setUp() {
        this.usuarioSalvo = repositorio.criarUsuario(usuario);
    }


    @Test
    void deveCriarUsuarioComDadosValidos() {
        assertNotNull(usuarioSalvo.getId());
        assertEquals(usuarioSalvo.getEmail(), usuario.getEmail());
        assertEquals(usuarioSalvo.getNome(), usuario.getNome());
        assertEquals(usuarioSalvo.getSenha(), usuario.getSenha());
    }


    @Test
    void deveBuscarUsuarioPorEmail() {
        Optional<Usuario> usuarioBuscado = repositorio.buscarUsuarioPorEmail(usuario.getEmail());
        assertTrue(usuarioBuscado.isPresent());
        Usuario encontrado = usuarioBuscado.get();

        assertEquals(usuarioSalvo.getId(), encontrado.getId());
        assertEquals(usuarioSalvo.getEmail(), encontrado.getEmail());
        assertEquals(usuarioSalvo.getNome(), encontrado.getNome());
        assertEquals(usuarioSalvo.getSenha(), encontrado.getSenha());
    }


    @Test
    void naoDeveEncontrarUsuarioComEmailInexistente() {
        Optional<Usuario> usuarioBuscado = repositorio.buscarUsuarioPorEmail(
                ConversorParaObjetosDeValor.email("emailInexistente@email.com")
        );
        assertTrue(usuarioBuscado.isEmpty());
    }
}