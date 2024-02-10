package com.coding.certification_system.api.repositories;

import com.coding.certification_system.api.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
}
