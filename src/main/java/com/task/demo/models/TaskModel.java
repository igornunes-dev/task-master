package com.task.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_TASK")
public class TaskModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, name = "title_task", updatable = false)
    private String title;

    @Column(nullable = false, name = "description_task", updatable = false)
    private String description;

    @Column(nullable = false, name = "created_date", updatable = false)
    private LocalDateTime create_date;

    @Column(nullable = false, name = "due_date", updatable = false)
    private LocalDate due_date;

    @Column(nullable = false, name = "status")
    private String status = "PENDING";

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CategoryModel category;

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    @PrePersist
    public void prePersist() {
        create_date = LocalDateTime.now();
        if(due_date == null) {
            due_date = LocalDate.now().plusDays(7);
        }
    }

    public LocalDate getDue_date() {
        return this.due_date;
    }

    public void setDue_date(LocalDate due_date) {
        this.due_date = due_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }
}
