package org.example.cadastro.domain.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.cadastro.application.dto.request.RestauranteRequest;
import org.example.cadastro.application.dto.response.RestauranteResponse;
import org.example.cadastro.domain.model.Restaurante;
import org.example.cadastro.domain.repository.IRestauranteRepository;
import org.example.cadastro.domain.service.contract.IRestauranteService;

import java.util.List;

import static org.example.cadastro.application.mapper.RestauranteMapper.RESTAURANTE_MAPPER;

@ApplicationScoped
@RequiredArgsConstructor
public class RestauranteServiceImpl implements IRestauranteService {

    private final IRestauranteRepository repository;

    @Override
    public List<RestauranteResponse> buscar() {
        return repository.listarTodosRestaurantes()
                .stream()
                .map(restaurante -> RESTAURANTE_MAPPER.toRestauranteResponse(restaurante))
                .toList();
    }

    @Override
    @Transactional
    public void adicionar(RestauranteRequest request) {
        var restaurante = RESTAURANTE_MAPPER.toRestaurante(request);
        repository.save(restaurante);
    }

    @Override
    @Transactional
    public void atualizar(Long id, RestauranteRequest request) {
        Restaurante restaurante = buscarPorId(id);
        restaurante.nome = request.nome();
        repository.save(restaurante);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        buscarPorId(id);
        repository.deletePorId(id);
    }

    public Restaurante buscarPorId(Long id) {
        return repository.obterPorIdOptional(id)
                .orElseThrow(NotFoundException::new);
    }
}
