package com.hmcts.dev.hmcts_backend.services;

import com.hmcts.dev.hmcts_backend.TaskRepository;
import com.hmcts.dev.hmcts_backend.domain.Task;
import com.hmcts.dev.hmcts_backend.dto.TaskDto;
import com.hmcts.dev.hmcts_backend.mappers.TaskMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public TaskDto createTask(@RequestBody TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        return taskMapper.toDto(
                taskRepository.save(task));
    }
}
