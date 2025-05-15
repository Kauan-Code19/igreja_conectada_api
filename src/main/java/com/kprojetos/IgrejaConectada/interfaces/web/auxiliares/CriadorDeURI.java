package com.kprojetos.IgrejaConectada.interfaces.web.auxiliares;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

public final class CriadorDeURI {
    private CriadorDeURI() {}

    public static URI paraRecurso(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
    }
}
