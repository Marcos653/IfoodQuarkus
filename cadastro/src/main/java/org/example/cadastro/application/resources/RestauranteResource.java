package org.example.cadastro.application.resources;

import org.example.cadastro.application.dto.request.RestauranteRequest;
import org.example.cadastro.application.dto.response.RestauranteResponse;
import org.example.cadastro.application.resources.contract.IRestauranteResource;
import org.example.cadastro.domain.service.contract.IRestauranteService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import jakarta.ws.rs.core.Response;

@RequiredArgsConstructor
public class RestauranteResource implements IRestauranteResource {

    private final IRestauranteService service;

    @Override
    public List<RestauranteResponse> buscar() {
        return service.buscar();
    }

    @Override
    public void adicionar(RestauranteRequest request) {
        service.adicionar(request);
        Response.status(Response.Status.CREATED).build();
    }

    @Override
    public void atualizar(Long id, RestauranteRequest request) {
        service.atualizar(id, request);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }
}
