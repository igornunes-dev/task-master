package com.task.demo.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_CATEGORY")
public class CategoryModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, name = "category_name")
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<TaskModel> tasks = new HashSet<>();

    public CategoryModel(String name) {
        this.name = name;
    }

    public CategoryModel() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TaskModel> getTasks() {
        return tasks;
    }

    public void setTasks(Set<TaskModel> tasks) {
        this.tasks = tasks;
    }
}
