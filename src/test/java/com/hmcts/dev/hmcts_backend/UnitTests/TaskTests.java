package com.hmcts.dev.hmcts_backend.UnitTests;

import com.hmcts.dev.hmcts_backend.domain.Task;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TaskTests {

    @Autowired
    private Validator validator;

    @Test
    void testTaskValid() {

        Task task = new Task(
                UUID.randomUUID(),
                "title",
                "description",
                "status",
                LocalDateTime.now()
        );

        Set<ConstraintViolation<Task>> violations = validator.validate(task);

        assertTrue(violations.isEmpty());
    }

    @Test
    void testTaskInvalidTitle() {

        Task task = new Task(
                UUID.randomUUID(),
                null,
                "description",
                "status",
                LocalDateTime.now()
        );

        Set<ConstraintViolation<Task>> violations = validator.validate(task);

        assertFalse(violations.isEmpty());
    }

    @Test
    void testTaskInvalidStatus() {

        Task task = new Task(
                UUID.randomUUID(),
                "title",
                "description",
                null,
                LocalDateTime.now()
        );

        Set<ConstraintViolation<Task>> violations = validator.validate(task);

        assertFalse(violations.isEmpty());
    }

    @Test
    void testTaskInvalidDateTime() {

        Task task = new Task(
                UUID.randomUUID(),
                "title",
                "description",
                "status",
                null
        );

        Set<ConstraintViolation<Task>> violations = validator.validate(task);

        assertFalse(violations.isEmpty());
    }

}
