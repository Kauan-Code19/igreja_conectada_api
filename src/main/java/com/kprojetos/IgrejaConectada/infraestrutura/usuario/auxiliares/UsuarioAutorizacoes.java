package com.kprojetos.IgrejaConectada.infraestrutura.usuario.auxiliares;

import com.kprojetos.IgrejaConectada.dominio.usuario.UsuarioTipo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class UsuarioAutorizacoes {
    private UsuarioAutorizacoes() {}


    public static Collection<? extends GrantedAuthority> obterAutorizacoes(UsuarioTipo tipo) {
        if (tipo == UsuarioTipo.ADMINISTRADOR) {
            return obterTodasAutorizacoes();
        }

        Set<SimpleGrantedAuthority> autorizacoes = new HashSet<>();
        autorizacoes.add(new SimpleGrantedAuthority("ROLE_" + tipo.name()));
        return autorizacoes;
    }


    private static Set<SimpleGrantedAuthority> obterTodasAutorizacoes() {
        Set<SimpleGrantedAuthority> autorizacoes = new HashSet<>();
        for (UsuarioTipo tipo : UsuarioTipo.values()) {
            autorizacoes.add(new SimpleGrantedAuthority("ROLE_" + tipo.name()));
        }

        return autorizacoes;
    }
}
