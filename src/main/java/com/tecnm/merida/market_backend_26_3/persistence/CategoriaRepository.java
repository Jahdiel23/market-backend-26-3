package com.tecnm.merida.market_backend_26_3.persistence;

import com.tecnm.merida.market_backend_26_3.domain.Category;
import com.tecnm.merida.market_backend_26_3.domain.repository.CategoryRepository;
import com.tecnm.merida.market_backend_26_3.persistence.crud.CategoriaCrudRepository;
import com.tecnm.merida.market_backend_26_3.persistence.entity.Categoria;
import com.tecnm.merida.market_backend_26_3.persistence.mapper.CategoryMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository implements CategoryRepository {

    private final CategoriaCrudRepository categoriaCrudRepository;
    private final CategoryMapper mapper;

    public CategoriaRepository(
            CategoriaCrudRepository categoriaCrudRepository,
            CategoryMapper mapper) {
        this.categoriaCrudRepository = categoriaCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Category> getAll() {
        List<Categoria> categorias =
                (List<Categoria>) categoriaCrudRepository.findAll();

        return categorias.stream()
                .map(mapper::toCategory)
                .toList();
    }

    @Override
    public Optional<Category> getCategory(int categoryId) {
        return categoriaCrudRepository.findById(categoryId)
                .map(mapper::toCategory);
    }

    @Override
    public Category save(Category category) {
        Categoria categoria = mapper.toCategoria(category);

        return mapper.toCategory(
                categoriaCrudRepository.save(categoria)
        );
    }

    @Override
    public void delete(int categoryId) {
        categoriaCrudRepository.deleteById(categoryId);
    }
}
