package com.examendesarrollo.backend.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.examendesarrollo.backend.repository.CategoryRepository;
import com.examendesarrollo.backend.model.Category;

@Service
public class CategoryService {

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public List<Category> findAll() {
        return repo.findAll();
    }
}
