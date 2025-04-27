package com.task.demo.controllers;

import com.task.demo.dtos.CategoryDto;
import com.task.demo.exceptions.CategoryNotFoundException;
import com.task.demo.models.CategoryModel;
import com.task.demo.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryModel>> getAllTasks() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAllCategory());
    }

    @PostMapping
    public ResponseEntity<CategoryModel> createCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.createCategory(categoryDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryModel> getCategoryById(@PathVariable("id")UUID id) throws CategoryNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.categoryFindById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable("id") UUID id) throws CategoryNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.deleteCategoryById(id));
    }

    @GetMapping("/fromTask")
    public ResponseEntity<Set<CategoryModel>> getWithTasks() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategoriesWithTasks());
    }

}
