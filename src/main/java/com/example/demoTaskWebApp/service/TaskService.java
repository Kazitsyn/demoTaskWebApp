package com.example.demoTaskWebApp.service;

import com.example.demoTaskWebApp.model.Task;
import com.example.demoTaskWebApp.model.TaskStatus;
import com.example.demoTaskWebApp.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Прокси клас междуконтроллером и репозиторием
 */
@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    /**
     * Прокси метод найти все задачи
     * @return
     */
    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    /**
     * Прокси метод сохранения задачи
     * @param task
     * @return
     */
    public Task saveTask(Task task){
        return taskRepository.save(task);
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
