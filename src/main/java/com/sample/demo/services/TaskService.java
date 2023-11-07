package com.sample.demo.services;

import com.sample.demo.controllers.request.TaskRequest;
import com.sample.demo.exceptions.DataNotFoundException;
import com.sample.demo.repositories.TaskRepository;
import com.sample.demo.repositories.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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
        Pageable pageable = PageRequest.of(0, 2, Sort.by(Sort.Direction.DESC, "id"));
        Page<Task> page = taskRepository.findAll(pageable);
        return page.toList();
    }

    @Cacheable(cacheNames = {"task"}, key = "#taskId", sync = true)
    public Task getTaskById(String taskId) throws DataNotFoundException {
        return taskRepository.findById(taskId).orElseThrow(() ->
                new DataNotFoundException("not_found")
        );
    }
}
