package com.example.todoapp.repository;

import com.example.todoapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "SELECT * FROM tasks WHERE status != 'DONE'", nativeQuery = true)
    List<Task> findUpcomingTasks();
}