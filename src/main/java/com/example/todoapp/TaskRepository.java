package com.example.todoapp;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "SELECT * FROM tasks WHERE status != 'DONE' AND deadline <= DATEADD(DAY, 3, GETDATE())", nativeQuery = true)
    List<Task> findUpcomingTasks();
}