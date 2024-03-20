package org.example.cadastro.application.dto.request;

import java.math.BigDecimal;

public record PratoRequest(
        String nome,
        String descricao,
        BigDecimal preco) {
}
