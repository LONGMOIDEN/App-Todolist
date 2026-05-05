package com.example.todoapp.controller;

import com.example.todoapp.service.TaskService;
import com.example.todoapp.entity.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> getAll() {
        return service.getAll();
    }

    @GetMapping("/upcoming")
    public List<Task> getUpcoming() {
        return service.getUpcoming();
    }
}