package com.coding.certification_system.api.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "alternatives")
public class Alternative {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String description;
    private String technology;
    private boolean isCorrect;
    private UUID question_id;
    @ManyToOne
    @JoinColumn(name = "question_id", insertable = false, updatable = false)
    private Question question;
    @CreationTimestamp
    private LocalDateTime createdAt;

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getTechnology() {
        return technology;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
