package com.examendesarrollo.backend.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.examendesarrollo.backend.model.Category;
import com.examendesarrollo.backend.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> list() {
        return service.findAll();
    }
}
