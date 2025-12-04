package com.hmcts.dev.hmcts_backend.mappers;

import com.hmcts.dev.hmcts_backend.domain.Task;
import com.hmcts.dev.hmcts_backend.dto.TaskDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TaskMapper {

    public Task toEntity(TaskDto taskDto) {
        return new Task(
                taskDto.getId(),
                taskDto.getTitle(),
                taskDto.getDescription(),
                taskDto.getStatus(),
                taskDto.getDueDateTime()
        );
    }

    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getDueDateTime()
        );
    }
}
