package com.example.demoTaskWebApp.service;

import com.example.demoTaskWebApp.model.Task;
import com.example.demoTaskWebApp.model.TaskStatus;
import com.example.demoTaskWebApp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Task saveTask(Task user){
        return taskRepository.save(user);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
    public void updateTask(Long id, TaskStatus taskStatus){
        Task temp = taskRepository.findById(id).get();
        temp.setStatus(taskStatus);
        taskRepository.save(temp);
    }
    public List<Task> getTasksByStatus(TaskStatus status){
        return taskRepository.getTasksByStatus(status);
    }
}
