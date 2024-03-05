package com.example.demoTaskWebApp.repository;

import com.example.demoTaskWebApp.model.Task;
import com.example.demoTaskWebApp.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    public List<Task> getTasksByStatus(TaskStatus status);
}
