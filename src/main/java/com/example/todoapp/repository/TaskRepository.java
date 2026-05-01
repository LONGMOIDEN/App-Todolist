package com.example.todoapp.repository;

import com.example.todoapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    // Reminder: task chưa DONE và gần deadline
    List<Task> findByStatusNotAndDeadlineLessThanEqual(String status, LocalDate date);
}