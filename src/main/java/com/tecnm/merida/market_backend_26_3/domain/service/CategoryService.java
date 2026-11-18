package com.tecnm.merida.market_backend_26_3.domain.service;

import com.tecnm.merida.market_backend_26_3.domain.Category;
import com.tecnm.merida.market_backend_26_3.domain.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int categoryId) {
        return categoryRepository.getCategory(categoryId);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Optional<Category> update(int categoryId, Category category) {
        return categoryRepository.getCategory(categoryId)
                .map(existingCategory -> {
                    category.setCategoryId(categoryId);
                    return categoryRepository.save(category);
                });
    }

    public boolean delete(int categoryId) {
        if (categoryRepository.getCategory(categoryId).isPresent()) {
            categoryRepository.delete(categoryId);
            return true;
        }
        return false;
    }
}
