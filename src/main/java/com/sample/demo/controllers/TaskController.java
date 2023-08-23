package com.sample.demo.controllers;

import com.sample.demo.controllers.request.TaskRequest;
import com.sample.demo.models.Role;
import com.sample.demo.repositories.entities.Task;
import com.sample.demo.services.TaskService;
import com.sample.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @PostMapping("/tasks")
    public Response<Object> createTask(@RequestBody TaskRequest taskRequest) {
        Task task = taskService.createTask(taskRequest);
        return CreateSuccessResponse(task);
    }

    @GetMapping("/tasks")
    public Response<Object> getTasks() {
        List<Task> tasks = taskService.getTasks();
        return CreateSuccessResponse(tasks);
    }

    @GetMapping("/tasks/{id}")
    public Response<Object> getTasks(@PathVariable("id") String id) {
        Task task = taskService.getTaskById(id);
        return CreateSuccessResponse(task);
    }

    @GetMapping("/roles")
    public Response<Object> getRoles() {
        List<Role> roles = userService.getRoles();
        return CreateSuccessResponse(roles);
    }

    Response<Object> CreateSuccessResponse(Object task) {
        Response<Object> response = new Response<>();
        response.code = "success";
        response.data = task;
        return response;
    }
}

