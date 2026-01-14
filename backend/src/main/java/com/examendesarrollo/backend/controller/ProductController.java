package com.examendesarrollo.backend.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.examendesarrollo.backend.model.Product;
import com.examendesarrollo.backend.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> list() {
        return service.findAll();
    }

    @GetMapping("/category/{id}")
    public List<Product> byCategory(@PathVariable Long id) {
        return service.findByCategory(id);
    }
}
