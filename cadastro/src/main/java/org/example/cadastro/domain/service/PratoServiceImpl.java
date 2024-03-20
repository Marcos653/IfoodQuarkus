package org.example.cadastro.domain.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.cadastro.application.dto.request.PratoRequest;
import org.example.cadastro.application.dto.response.PratoResponse;
import org.example.cadastro.domain.model.Prato;
import org.example.cadastro.domain.repository.IPratoRepository;
import org.example.cadastro.domain.service.contract.IPratoService;
import org.example.cadastro.domain.service.contract.IRestauranteService;

import java.util.List;

import static org.example.cadastro.application.mapper.PratoMapper.PRATO_MAPPER;

@ApplicationScoped
@RequiredArgsConstructor
public class PratoServiceImpl implements IPratoService {

    private final IRestauranteService restauranteService;
    private final IPratoRepository repository;

    @Override
    public List<PratoResponse> buscarPratosPeloIdRestaurante(Long idRestaurante) {
        return repository.listarPratos(restauranteService.buscarPorId(idRestaurante))
                .stream()
                .map(prato -> PRATO_MAPPER.toPratoResponse(prato))
                .toList();
    }

    @Override
    @Transactional
    public void adicionar(Long idRestaurante, PratoRequest request) {
        Prato prato = PRATO_MAPPER.toPrato(request);
        prato.restaurante = restauranteService.buscarPorId(idRestaurante);
        repository.save(prato);
    }

    @Override
    @Transactional
    public void atualizar(Long idRestaurante, Long idPrato, PratoRequest request) {
        restauranteService.buscarPorId(idRestaurante);
        Prato prato = buscarPorId(idPrato);
        prato.preco = request.preco();
        repository.save(prato);
    }

    @Override
    @Transactional
    public void delete(Long idRestaurante, Long idPrato) {
        restauranteService.buscarPorId(idRestaurante);
        buscarPorId(idPrato);
        repository.deletePorId(idPrato);
    }

    private Prato buscarPorId(Long id) {
        return repository.obterPorIdOptional(id)
                .orElseThrow(NotFoundException::new);
    }
}
