package org.example.cadastro.application.resources;

import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.example.cadastro.application.dto.request.PratoRequest;
import org.example.cadastro.application.dto.response.PratoResponse;
import org.example.cadastro.application.resources.contract.IPratoResource;
import org.example.cadastro.domain.service.contract.IPratoService;

import java.util.List;

@RequiredArgsConstructor
public class PratoResource implements IPratoResource {

    private final IPratoService service;

    @Override
    public List<PratoResponse> buscarPratosPeloIdRestaurante(Long idRestaurante) {
        return service.buscarPratosPeloIdRestaurante(idRestaurante);
    }

    @Override
    public void adicionar(Long idRestaurante, PratoRequest request) {
        service.adicionar(idRestaurante, request);
        Response.status(Response.Status.CREATED).build();
    }

    @Override
    public void atualizar(Long idRestaurante, Long idPrato, PratoRequest request) {
        service.atualizar(idRestaurante, idPrato, request);
    }

    @Override
    public void delete(Long idRestaurante, Long idPrato) {
        service.delete(idRestaurante, idPrato);
    }
}
