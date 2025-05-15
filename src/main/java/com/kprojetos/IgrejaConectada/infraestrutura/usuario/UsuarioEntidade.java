package com.kprojetos.IgrejaConectada.infraestrutura.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@Getter
public class UsuarioEntidade {
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


    public UsuarioEntidade(
            Long id,
            String nome,
            String email,
            String senha
    ) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
}
