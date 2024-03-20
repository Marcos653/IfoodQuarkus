package org.example.cadastro.domain.repository;

import org.example.cadastro.domain.model.Restaurante;

import java.util.List;
import java.util.Optional;

public interface IRestauranteRepository {

    List<Restaurante> listarTodosRestaurantes();

    Optional<Restaurante> obterPorIdOptional(Long id);

    void save(Restaurante restaurante);

    boolean deletePorId(Long id);
}
