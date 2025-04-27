package com.task.demo.repositories;

import com.task.demo.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<CategoryModel, UUID> {
    Optional<CategoryModel> findByName(String name);

    @Query("SELECT DISTINCT c FROM CategoryModel c JOIN FETCH c.tasks WHERE SIZE(c.tasks) > 0")
    Set<CategoryModel> getCategoriesWithTasks();
}
