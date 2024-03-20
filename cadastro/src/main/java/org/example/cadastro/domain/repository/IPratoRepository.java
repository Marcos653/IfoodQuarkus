package org.example.cadastro.domain.repository;

import org.example.cadastro.domain.model.Prato;
import org.example.cadastro.domain.model.Restaurante;

import java.util.List;
import java.util.Optional;

public interface IPratoRepository {

    List<Prato> listarPratos(Restaurante restaurante);

    Optional<Prato> obterPorIdOptional(Long id);

    void save(Prato prato);

    boolean deletePorId(Long id);
}
