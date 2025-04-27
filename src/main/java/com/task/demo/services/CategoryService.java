package com.task.demo.services;

import com.task.demo.dtos.CategoryDto;
import com.task.demo.exceptions.CategoryNotFoundException;
import com.task.demo.models.CategoryModel;
import com.task.demo.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryModel> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Transactional
    public CategoryModel createCategory(CategoryDto categoryDto) {
        CategoryModel category = new CategoryModel();

        category.setName(categoryDto.name());

        return categoryRepository.save(category);
    }

    public CategoryModel categoryFindById(UUID categoryId) throws CategoryNotFoundException {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));
    }

    public String deleteCategoryById(UUID categoryId) throws CategoryNotFoundException {
        if(!categoryRepository.existsById(categoryId)) {
            throw new CategoryNotFoundException("Category not found");
        }
        categoryRepository.deleteById(categoryId);
        return "Delete completed";
    }

    public CategoryModel getCategoryByName(String categoryName) throws CategoryNotFoundException {
        return categoryRepository.findByName(categoryName).orElseThrow(() -> new CategoryNotFoundException("Category not found"));
    }

    public Set<CategoryModel> getCategoriesWithTasks() {
        return categoryRepository.getCategoriesWithTasks();
    }
}
