package com.kprojetos.IgrejaConectada.infraestrutura.configuracao;

import com.kprojetos.IgrejaConectada.aplicacao.usuario.casosDeUso.CriarUsuario;
import com.kprojetos.IgrejaConectada.dominio.usuario.UsuarioRepositorio;
import com.kprojetos.IgrejaConectada.infraestrutura.usuario.UsuarioRepositorioImpl;
import com.kprojetos.IgrejaConectada.infraestrutura.usuario.UsuarioRepositorioJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RaizDeComposicao {
    private final UsuarioRepositorioJpa usuarioRepositorioJpa;


    public RaizDeComposicao(UsuarioRepositorioJpa usuarioRepositorioJpa) {
        this.usuarioRepositorioJpa = usuarioRepositorioJpa;
    }


    @Bean
    public UsuarioRepositorio usuarioRepositorio() {
        return new UsuarioRepositorioImpl(usuarioRepositorioJpa);
    }


    @Bean
    public CriarUsuario criarUsuario() {
        return new CriarUsuario(usuarioRepositorio());
    }
}
