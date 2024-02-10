package com.coding.certification_system.api.repositories;

import com.coding.certification_system.api.entities.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CertificationRepository extends JpaRepository<Certification, UUID> {
    @Query("SELECT certification " +
           "  FROM Certification certification " +
           " INNER JOIN certification.student " +
           " WHERE student.email = :email" +
           "   AND certification.technology = :technology")
    List<Certification> findByStudentEmailAndTechnology(String email, String technology);
}
