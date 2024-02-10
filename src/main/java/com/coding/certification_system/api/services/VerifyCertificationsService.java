package com.coding.certification_system.api.services;

import com.coding.certification_system.api.dtos.VerifyHasCertificationDTO;
import com.coding.certification_system.api.repositories.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyCertificationsService {

    @Autowired
    private CertificationRepository certificationRepository;

    public boolean validateCertification(VerifyHasCertificationDTO verifyHasCertificationDto) {
        var result = certificationRepository
                .findByStudentEmailAndTechnology(verifyHasCertificationDto.email(), verifyHasCertificationDto.technology());

        return !result.isEmpty();
    }
}
