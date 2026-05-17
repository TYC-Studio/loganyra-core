package org.tyc_studio.loganyra.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "logs")
public class LogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    public String appName;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    public String content;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp()
    private LocalDateTime createdTime;

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    @Override
    public String toString() {
        return "{" + this.id + "--" + this.appName + ": " + this.content + "(" + this.getCreatedTime().toString() + ")}";
    }
}
