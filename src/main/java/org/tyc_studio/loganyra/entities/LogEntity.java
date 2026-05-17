package org.tyc_studio.loganyra.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "logs")
public class LogEntity {
    public LogEntity() {
    }

    public LogEntity(String appName, String content) {
        this.appName = appName;
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String appName;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String content;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp()
    private LocalDateTime createdTime;
}
