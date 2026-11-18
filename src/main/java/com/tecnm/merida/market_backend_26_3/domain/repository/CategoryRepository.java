package com.tecnm.merida.market_backend_26_3.domain.repository;

import com.tecnm.merida.market_backend_26_3.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    List<Category> getAll();

    Optional<Category> getCategory(int categoryId);

    Category save(Category category);

    void delete(int categoryId);
}
