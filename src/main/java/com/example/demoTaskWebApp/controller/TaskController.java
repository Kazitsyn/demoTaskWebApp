package com.example.demoTaskWebApp.controller;

import com.example.demoTaskWebApp.model.Task;
import com.example.demoTaskWebApp.model.TaskStatus;
import com.example.demoTaskWebApp.repository.TaskRepository;
import com.example.demoTaskWebApp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/addTask")
    public Task addTask(@RequestBody Task task){
        return taskService.saveTask(task);
    }
    @GetMapping("/task")
    public List<Task> getAllTask(){
        return taskService.findAll();
    }
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
//        return taskService.findAll().stream().filter(t -> t.getStatus().equals(status)).toList();
        return taskService.getTasksByStatus(status);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        taskService.updateTask(id, task.getStatus());
        return task;
    }
}
