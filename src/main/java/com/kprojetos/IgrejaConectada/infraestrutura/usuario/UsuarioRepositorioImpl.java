package com.kprojetos.IgrejaConectada.infraestrutura.usuario;

import com.kprojetos.IgrejaConectada.aplicacao.ConversorParaObjetosDeValor;
import com.kprojetos.IgrejaConectada.aplicacao.usuario.auxiliares.UsuarioFabrica;
import com.kprojetos.IgrejaConectada.dominio.objetosDeValor.Email;
import com.kprojetos.IgrejaConectada.dominio.usuario.Usuario;
import com.kprojetos.IgrejaConectada.dominio.usuario.UsuarioRepositorio;
import com.kprojetos.IgrejaConectada.infraestrutura.usuario.auxiliares.UsuarioEntidadeFabrica;

import java.util.Optional;

public class UsuarioRepositorioImpl implements UsuarioRepositorio {
    private final UsuarioRepositorioJpa usuarioRepositorioJpa;


    public UsuarioRepositorioImpl(
            UsuarioRepositorioJpa usuarioRepositorioJpa
    ) {
        this.usuarioRepositorioJpa = usuarioRepositorioJpa;
    }


    @Override
    public Usuario criarUsuario(Usuario usuario) {
        UsuarioEntidade usuarioEntidade = UsuarioEntidadeFabrica.criar(usuario);
        usuarioEntidade = usuarioRepositorioJpa.save(usuarioEntidade);

        return UsuarioFabrica.criar(
                usuarioEntidade.getId(),
                usuarioEntidade.getNome(),
                usuarioEntidade.getEmail(),
                usuarioEntidade.getSenha(),
                usuarioEntidade.getTipo()
        );
    }


    @Override
    public Optional<Usuario> buscarUsuarioPorEmail(Email email) {
        Optional<UsuarioEntidade> usuarioEntidade = usuarioRepositorioJpa
                .findByEmail(email.getValor());

        return usuarioEntidade.map(entidade -> new Usuario(
                entidade.getId(),
                ConversorParaObjetosDeValor.nome(entidade.getNome()),
                ConversorParaObjetosDeValor.email(entidade.getEmail()),
                ConversorParaObjetosDeValor.senha(entidade.getSenha()),
                entidade.getTipo()
        ));
    }
}
