package org.example.cadastro.application.dto.response;

import org.example.cadastro.domain.model.Localizacao;

import java.util.Date;

public record RestauranteResponse(
        Long id,
        String proprietario,
        String cnpj, String nome,
        Localizacao localizacao,
        Date dataCriacao,
        Date dataAtualizacao) {
}
