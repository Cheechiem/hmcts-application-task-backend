package com.hmcts.dev.hmcts_backend.UnitTests;

import com.hmcts.dev.hmcts_backend.TaskRepository;
import com.hmcts.dev.hmcts_backend.domain.Task;
import com.hmcts.dev.hmcts_backend.dto.TaskDto;
import com.hmcts.dev.hmcts_backend.mappers.TaskMapper;
import com.hmcts.dev.hmcts_backend.services.TaskService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TaskServiceTests {

    @Autowired
    TaskService taskService;

    @MockitoBean
    TaskRepository taskRepository;

    @Test
    void testCreateTaskCallsRepository() {
        TaskDto taskDto = new TaskDto(
                UUID.randomUUID(),
                "title",
                "description",
                "status",
                LocalDateTime.now()
        );

        when(taskRepository.save(Mockito.any())).thenReturn(new Task());

        taskService.createTask(taskDto);

        verify(taskRepository).save(argThat(task ->
                task.getId().equals(taskDto.getId()) &&
                        task.getTitle().equals(taskDto.getTitle()) &&
                        task.getDescription().equals(taskDto.getDescription()) &&
                        task.getStatus().equals(taskDto.getStatus()) &&
                        task.getDueDateTime().equals(taskDto.getDueDateTime())
        ));
    }
}
