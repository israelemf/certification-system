package com.coding.certification_system.api.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(length = 50)
    private String technology;
    private String description;
    @OneToMany(mappedBy = "question_id")
    private List<Alternative> alternatives;

    public UUID getId() {
        return id;
    }

    public String getTechnology() {
        return technology;
    }

    public String getDescription() {
        return description;
    }

    public List<Alternative> getAlternatives() {
        return alternatives;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAlternatives(List<Alternative> alternatives) {
        this.alternatives = alternatives;
    }
}
