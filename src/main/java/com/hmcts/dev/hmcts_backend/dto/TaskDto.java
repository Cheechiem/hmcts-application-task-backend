package com.hmcts.dev.hmcts_backend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class TaskDto {

    private final UUID id;
    @NotNull
    @Size(min = 1, max = 255)
    private final String title;
    private final String description;
    @NotNull
    @Size(min = 1, max = 255)
    private final String status;
    @NotNull
    private final LocalDateTime dueDateTime;

}
