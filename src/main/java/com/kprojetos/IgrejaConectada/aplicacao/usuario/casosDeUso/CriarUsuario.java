package com.kprojetos.IgrejaConectada.aplicacao.usuario.casosDeUso;

import com.kprojetos.IgrejaConectada.aplicacao.ConversorParaObjetosDeValor;
import com.kprojetos.IgrejaConectada.aplicacao.usuario.auxiliares.UsuarioFabrica;
import com.kprojetos.IgrejaConectada.aplicacao.usuario.auxiliares.UsuarioMapeador;
import com.kprojetos.IgrejaConectada.aplicacao.usuario.dtos.CriarUsuarioDTO;
import com.kprojetos.IgrejaConectada.aplicacao.usuario.dtos.UsuarioRespostaDTO;
import com.kprojetos.IgrejaConectada.dominio.objetosDeValor.Email;
import com.kprojetos.IgrejaConectada.dominio.usuario.Usuario;
import com.kprojetos.IgrejaConectada.dominio.usuario.UsuarioRepositorio;

public class CriarUsuario {
    private final UsuarioRepositorio repositorio;


    public CriarUsuario(UsuarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }


    public UsuarioRespostaDTO criarUsuario(CriarUsuarioDTO dto) {
        verificarSeUsuarioJaExiste(dto.email());
        Usuario usuario = UsuarioFabrica.criar(dto);
        usuario = repositorio.criarUsuario(usuario);

        return UsuarioMapeador.paraUsuarioRespostaDTO(usuario);
    }


    private void verificarSeUsuarioJaExiste(String email) {
        Email emailObjetoValor = ConversorParaObjetosDeValor.email(email);
        boolean usuarioExiste = repositorio.buscarUsuarioPorEmail(emailObjetoValor).isPresent();

        if (usuarioExiste) {
            throw new IllegalArgumentException(
                    "Usuário já existe com o email: " + email
            );
        }
    }
}
