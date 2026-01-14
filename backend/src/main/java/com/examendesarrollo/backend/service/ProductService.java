package com.examendesarrollo.backend.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.examendesarrollo.backend.repository.ProductRepository;
import com.examendesarrollo.backend.model.Product;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> findAll() {
        return repo.findAll();
    }

    public List<Product> findByCategory(Long categoryId) {
        return repo.findByCategoryId(categoryId);
    }
}
