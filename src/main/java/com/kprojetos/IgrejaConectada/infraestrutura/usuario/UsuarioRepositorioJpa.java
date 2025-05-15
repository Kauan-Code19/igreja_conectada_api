package com.kprojetos.IgrejaConectada.infraestrutura.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepositorioJpa extends JpaRepository<UsuarioEntidade, Long> {
    Optional<UsuarioEntidade> findByEmail(String email);
}
