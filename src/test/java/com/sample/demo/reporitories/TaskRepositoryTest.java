package com.sample.demo.reporitories;

import com.sample.demo.controllers.request.TaskRequest;
import com.sample.demo.repositories.TaskRepository;
import com.sample.demo.repositories.entities.Task;
import com.sample.demo.services.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

class TaskRepositoryTest  {

    @Mock private TaskRepository taskRepository;

    private TaskService taskService;

    @BeforeEach void setup() {
        this.taskService = new TaskService(this.taskRepository);
    }

    @Test void finAll() {
        taskService.getTasks();
        verify(taskRepository).findAll();
    }

    @Test void createTask() {
        //given
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTitle("test");

        //when
        Task task = taskService.createTask(taskRequest);

        //then
        assertEquals("test", task.getTitle());
        verify(taskRepository).save(task);
    }
}
