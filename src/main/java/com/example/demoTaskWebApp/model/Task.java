package com.example.demoTaskWebApp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Enumerated
    private TaskStatus status = TaskStatus.NOT_STARTED;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime localDateTime = LocalDateTime.now();

}
