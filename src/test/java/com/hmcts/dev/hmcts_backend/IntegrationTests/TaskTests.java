package com.hmcts.dev.hmcts_backend.IntegrationTests;

import com.hmcts.dev.hmcts_backend.TaskRepository;
import com.hmcts.dev.hmcts_backend.controllers.TaskController;
import com.hmcts.dev.hmcts_backend.domain.Task;
import com.hmcts.dev.hmcts_backend.dto.TaskDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TaskTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private TaskRepository taskRepository;

    @BeforeEach
    void cleanup() {
        taskRepository.deleteAll();
    }

    @Test
    public void testCreateTaskEndpoint() throws Exception {
        TaskDto taskDto = new TaskDto(
                UUID.randomUUID(),
                "title",
                "description",
                "status",
                LocalDateTime.now()
        );

        when(taskRepository.save(Mockito.any())).thenReturn(new Task());

        mockMvc.perform(post("/task/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(taskDto)))
                .andExpect(status().isOk());
    }
}
