package com.hmcts.dev.hmcts_backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    private String title;

    private String description;

    @NotNull
    private String status;

    @NotNull
    private LocalDateTime dueDateTime;
}
