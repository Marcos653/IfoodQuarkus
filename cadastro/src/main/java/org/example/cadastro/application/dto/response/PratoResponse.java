package org.example.cadastro.application.dto.response;

import java.math.BigDecimal;

public record PratoResponse(
        Long id,
        String nome,
        String descricao,
        RestauranteResponse restaurante,
        BigDecimal preco) {
}
