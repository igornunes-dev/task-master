package com.task.demo.controllers;

import com.task.demo.dtos.TaskDto;
import com.task.demo.exceptions.CategoryNotFoundException;
import com.task.demo.exceptions.TaskNotFoundException;
import com.task.demo.models.CategoryModel;
import com.task.demo.models.TaskModel;
import com.task.demo.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping
    public ResponseEntity<List<TaskModel>> getAllTasks() {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getAllTasks());
    }

    @PostMapping
    public ResponseEntity<TaskModel> createTasks(@RequestBody TaskDto taskDto) throws CategoryNotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTaks(taskDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TaskModel>> getTaskById(@PathVariable("id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findTaskById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable("id") UUID id) throws TaskNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.deleteTaskById(id));
    }

    @PutMapping("/setStatusInProgress/{id}")
    public ResponseEntity<TaskModel> setStatusInProgress(@PathVariable("id") UUID id) throws TaskNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.setStatusInProgress(id));
    }

    @PutMapping("/setStatusCompleted/{id}")
    public ResponseEntity<String> setStatusCompleted(@PathVariable("id") UUID id) throws TaskNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.setStatusCompleted(id));
    }



}
