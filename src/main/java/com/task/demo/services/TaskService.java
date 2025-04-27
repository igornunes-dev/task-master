package com.task.demo.services;

import com.task.demo.dtos.TaskDto;
import com.task.demo.exceptions.CategoryNotFoundException;
import com.task.demo.exceptions.TaskNotFoundException;
import com.task.demo.models.CategoryModel;
import com.task.demo.models.TaskModel;
import com.task.demo.repositories.CategoryRepository;
import com.task.demo.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;

    public TaskService(TaskRepository taskRepository, CategoryRepository categoryRepository) {
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<TaskModel> getAllTasks() {
        return taskRepository.findAll();
    }

    @Transactional
    public TaskModel createTaks(TaskDto taskDto) throws CategoryNotFoundException {
        TaskModel task = new TaskModel();

        task.setTitle(taskDto.title());
        task.setDescription(taskDto.description());

        LocalDate now = LocalDate.now();
        LocalDate dueDate = now.plusDays(taskDto.dueInDays());

        task.setDue_date(dueDate);

        CategoryModel category = categoryRepository.findByName(taskDto.category())
                .orElseThrow(() -> new CategoryNotFoundException("Categoria não encontrada"));

        task.setCategory(category);

        task.setStatus("PENDING");

        return taskRepository.save(task);
    }

    public Optional<TaskModel> findTaskById(UUID id) {
        return taskRepository.findById(id);
    }

    public String deleteTaskById(UUID id) throws TaskNotFoundException {
        if(!taskRepository.existsById(id)) {
            throw new TaskNotFoundException("Category not found");
        }
        taskRepository.deleteById(id);
        return "Delete completed";
    }


    public TaskModel setStatusInProgress(UUID id) throws TaskNotFoundException {
        Optional<TaskModel> taskId = taskRepository.findById(id);

        if(taskId.isEmpty()) {
            throw new TaskNotFoundException("Task not found");
        }

        TaskModel taskModel = taskId.get();
        taskModel.setStatus("IN_PROGRESS");
        return taskRepository.save(taskModel);
    }

    public String setStatusCompleted(UUID id) throws TaskNotFoundException {
        Optional<TaskModel> taskId = taskRepository.findById(id);

        if(taskId.isEmpty()) {
            throw new TaskNotFoundException("Task not found");
        }

        TaskModel taskModel = taskId.get();
        taskRepository.delete(taskModel);
        return "Task completed and deleted";

    }

}
