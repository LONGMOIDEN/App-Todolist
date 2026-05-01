package com.example.todoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    // 👉 API lấy tất cả task
    @GetMapping
    @ResponseBody
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // 👉 API reminder (phần của bạn)
    @GetMapping("/upcoming")
    @ResponseBody
    public List<Task> getUpcomingTasks() {
        return taskRepository.findUpcomingTasks();
    }
}