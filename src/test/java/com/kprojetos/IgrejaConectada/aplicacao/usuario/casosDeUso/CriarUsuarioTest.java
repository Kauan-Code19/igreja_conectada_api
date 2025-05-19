package com.kprojetos.IgrejaConectada.aplicacao.usuario.casosDeUso;

import com.kprojetos.IgrejaConectada.aplicacao.auxiliares.ConversorParaObjetosDeValor;
import com.kprojetos.IgrejaConectada.aplicacao.auxiliares.UsuarioFabrica;
import com.kprojetos.IgrejaConectada.aplicacao.auxiliares.UsuarioMapeador;
import com.kprojetos.IgrejaConectada.aplicacao.usuario.dtos.CriarUsuarioDTO;
import com.kprojetos.IgrejaConectada.aplicacao.usuario.dtos.UsuarioRespostaDTO;
import com.kprojetos.IgrejaConectada.dominio.objetosDeValor.Email;
import com.kprojetos.IgrejaConectada.dominio.usuario.Usuario;
import com.kprojetos.IgrejaConectada.dominio.usuario.UsuarioRepositorio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CriarUsuarioTest {
    private final CriarUsuarioDTO dto = new CriarUsuarioDTO(
            "João Silva",
            "joao@email.com",
            "senhaSegura@123"
    );
    private final Usuario usuarioComId = UsuarioFabrica.criar(
            1L,
            "João Silva",
            "joao@email.com",
            "senhaSegura@123"
    );

    @Mock
    UsuarioRepositorio usuarioRepositorio;

    @InjectMocks
    CriarUsuario criarUsuario;


    @Test
    void deveCriarUsuarioComDadosValidos() {
        Email email = ConversorParaObjetosDeValor.email(dto.email());
        when(usuarioRepositorio.buscarUsuarioPorEmail(email))
                .thenReturn(Optional.empty());

        when(usuarioRepositorio.criarUsuario(any(Usuario.class)))
                .thenReturn(usuarioComId);

        UsuarioRespostaDTO dtoResposta = criarUsuario.criarUsuario(dto);
        UsuarioRespostaDTO usuarioEsperado = UsuarioMapeador.paraUsuarioRespostaDTO(usuarioComId);

        assertEquals(dtoResposta, usuarioEsperado);
    }


    @Test
    void deveRetornarUsuarioJaExistente() {
        Email email = ConversorParaObjetosDeValor.email(dto.email());
        when(usuarioRepositorio.buscarUsuarioPorEmail(email))
                .thenReturn(Optional.of(usuarioComId));

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> criarUsuario.criarUsuario(dto)
        );

        assertEquals(
                "Usuário já existe com o email: " + dto.email(),
                exception.getMessage()
        );
    }
}