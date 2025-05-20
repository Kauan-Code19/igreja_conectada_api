package com.kprojetos.IgrejaConectada.infraestrutura.usuario;

import com.kprojetos.IgrejaConectada.dominio.usuario.UsuarioTipo;
import com.kprojetos.IgrejaConectada.infraestrutura.usuario.auxiliares.UsuarioAutorizacoes;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@Getter
public class UsuarioEntidade implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, updatable = false)
    private UsuarioTipo tipo;


    public UsuarioEntidade(
            Long id,
            String nome,
            String email,
            String senha,
            UsuarioTipo tipo
    ) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return UsuarioAutorizacoes.obterAutorizacoes(tipo);
    }


    @Override
    public String getPassword() {
        return senha;
    }


    @Override
    public String getUsername() {
        return email;
    }


    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }


    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }


    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
