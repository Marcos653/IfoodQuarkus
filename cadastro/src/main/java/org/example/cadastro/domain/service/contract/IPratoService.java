package org.example.cadastro.domain.service.contract;

import org.example.cadastro.application.dto.request.PratoRequest;
import org.example.cadastro.application.dto.response.PratoResponse;

import java.util.List;

public interface IPratoService {

    List<PratoResponse> buscarPratosPeloIdRestaurante(Long idRestaurante);

    void adicionar(Long idRestaurante, PratoRequest request);

    void atualizar(Long idRestaurante, Long idPrato, PratoRequest request);

    void delete(Long idRestaurante, Long idPrato);
}
