package org.example.cadastro.infra.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.cadastro.domain.model.Prato;
import org.example.cadastro.domain.model.Restaurante;
import org.example.cadastro.domain.repository.IPratoRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PratoRepositoryAdapter implements PanacheRepositoryBase<Prato, Long>, IPratoRepository {

    @Override
    public List<Prato> listarPratos(Restaurante restaurante) {
        return list("restaurante", restaurante);
    }

    @Override
    public Optional<Prato> obterPorIdOptional(Long id) {
        return findByIdOptional(id);
    }

    @Override
    public void save(Prato prato) {
        persist(prato);
    }

    @Override
    public boolean deletePorId(Long id) {
        return deleteById(id);
    }
}
