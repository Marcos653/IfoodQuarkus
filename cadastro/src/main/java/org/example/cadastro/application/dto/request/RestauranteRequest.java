package org.example.cadastro.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RestauranteRequest(
        @NotBlank
        String proprietario,
        @NotBlank
        @Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}")
        String cnpj,
        @NotBlank
        @Size(min = 3, max = 30)
        String nome,
        LocalizacaoRequest localizacao) {
}
