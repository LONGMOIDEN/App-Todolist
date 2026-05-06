package com.example.todoapp.service;

import com.example.todoapp.entity.Task;
import com.example.todoapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<Task> getAll() {
        return repo.findAll();
    }

    public List<Task> getUpcoming() {
        LocalDate today = LocalDate.now();
        return repo.findByStatusNotAndDeadlineBetween("DONE", today, today.plusDays(3));
    }

    public Task save(Task task) {
        return repo.save(task);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}