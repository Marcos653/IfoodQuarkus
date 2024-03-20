package org.example.cadastro.domain.service.contract;

import org.example.cadastro.application.dto.request.RestauranteRequest;
import org.example.cadastro.application.dto.response.RestauranteResponse;
import org.example.cadastro.domain.model.Restaurante;

import java.util.List;

public interface IRestauranteService {

    List<RestauranteResponse> buscar();

    void adicionar(RestauranteRequest request);

    void atualizar(Long id, RestauranteRequest request);

    void delete(Long id);

    Restaurante buscarPorId(Long id);
}
