package com.sample.demo.reporitories;

import com.sample.demo.controllers.TaskController;
import com.sample.demo.controllers.request.TaskRequest;
import com.sample.demo.repositories.entities.Task;
import com.sample.demo.services.TaskService;
import com.sample.demo.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

class UserServiceTest {

    @Mock private UserService userService;
    private TaskService taskService;
    private TaskController taskController;

    @BeforeEach void setup() {
        this.taskController = new TaskController(this.taskService, this.userService);
    }

    @Test void getRoles() {
        taskController.getRoles();
        verify(userService).getRoles();
    }
}
