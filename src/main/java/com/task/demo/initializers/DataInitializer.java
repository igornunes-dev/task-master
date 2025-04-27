package com.task.demo.initializers;

import com.task.demo.models.CategoryModel;
import com.task.demo.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {
    private final CategoryRepository categoryRepository;


    public DataInitializer(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String ...args) throws Exception {
        if(categoryRepository.count() == 0) {
            List<CategoryModel> categoryModels = List.of(
                    new CategoryModel("Faculdade"),
                    new CategoryModel("Pessoal"),
                    new CategoryModel("Trabalho")
            );
            categoryRepository.saveAll(categoryModels);

        }
    }
}
