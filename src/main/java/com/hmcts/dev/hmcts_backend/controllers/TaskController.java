package com.hmcts.dev.hmcts_backend.controllers;

import com.hmcts.dev.hmcts_backend.dto.TaskDto;
import com.hmcts.dev.hmcts_backend.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/task/create")
    public ResponseEntity<TaskDto> createTask(@RequestBody @Valid TaskDto task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }
}
