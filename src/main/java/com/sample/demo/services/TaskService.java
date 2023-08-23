package com.sample.demo.services;

import com.sample.demo.controllers.request.TaskRequest;
import com.sample.demo.exceptions.DataNotFoundException;
import com.sample.demo.repositories.TaskRepository;
import com.sample.demo.repositories.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(TaskRequest taskRequest) {
        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        taskRepository.save(task);
        return task;
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Cacheable(cacheNames = {"task"}, key = "#taskId", sync = true)
    public Task getTaskById(String taskId) throws DataNotFoundException {
        return taskRepository.findById(taskId).orElseThrow(() ->
                new DataNotFoundException("not_found")
        );
    }
}
