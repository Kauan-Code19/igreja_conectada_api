package com.kprojetos.IgrejaConectada.dominio.usuario;

import com.kprojetos.IgrejaConectada.dominio.objetosDeValor.Email;
import java.util.Optional;

public interface UsuarioRepositorio {
    Usuario criarUsuario(Usuario usuario);
    Optional<Usuario> buscarUsuarioPorEmail(Email email);
}
