package com.example.todoapp.controller;

import com.example.todoapp.entity.Task;
import com.example.todoapp.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin("*")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    // GET ALL
    @GetMapping
    public List<Task> getAll() {
        return service.getAll();
    }

    // CREATE
    @PostMapping
    public Task create(@RequestBody Task task) {
        return service.create(task);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) {
        return service.update(id, task);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    // 🔔 REMINDER API
    @GetMapping("/upcoming")
    public List<Task> getUpcoming() {
        return service.getUpcomingTasks();
    }
}