package org.example.cadastro.infra.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.example.cadastro.domain.model.Restaurante;
import org.example.cadastro.domain.repository.IRestauranteRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class RestauranteRepositoryAdapter implements PanacheRepositoryBase<Restaurante, Long>, IRestauranteRepository {

    @Override
    public List<Restaurante> listarTodosRestaurantes() {
        return listAll();
    }

    @Override
    public Optional<Restaurante> obterPorIdOptional(Long id) {
        return findByIdOptional(id);
    }

    @Override
    public void save(Restaurante restaurante) {
        persist(restaurante);
    }

    @Override
    public boolean deletePorId(Long id) {
        return deleteById(id);
    }
}
