package com.kprojetos.IgrejaConectada.interfaces.web.usuario;

import com.kprojetos.IgrejaConectada.aplicacao.usuario.casosDeUso.CriarUsuario;
import com.kprojetos.IgrejaConectada.aplicacao.usuario.dtos.CriarUsuarioDTO;
import com.kprojetos.IgrejaConectada.aplicacao.usuario.dtos.UsuarioRespostaDTO;
import com.kprojetos.IgrejaConectada.interfaces.web.auxiliares.CriadorDeURI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {
    private final CriarUsuario criarUsuario;


    public UsuarioControlador(CriarUsuario criarUsuario) {
        this.criarUsuario = criarUsuario;
    }


    @PostMapping
    public ResponseEntity<UsuarioRespostaDTO> criarUsuario(
            @RequestBody CriarUsuarioDTO dto
    ) {
        UsuarioRespostaDTO usuarioRespostaDTO = criarUsuario.criarUsuario(dto);
        URI uri = CriadorDeURI.paraRecurso(usuarioRespostaDTO.id());
        return ResponseEntity.created(uri).body(usuarioRespostaDTO);
    }
}
