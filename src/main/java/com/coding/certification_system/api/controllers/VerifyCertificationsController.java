package com.coding.certification_system.api.controllers;

import com.coding.certification_system.api.dtos.VerifyHasCertificationDTO;
import com.coding.certification_system.api.services.VerifyCertificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class VerifyCertificationsController {
    @Autowired
    private VerifyCertificationsService verifyCertificationsService;

    @PostMapping("/ifHasCertification")
    public String verifyStudentHasCertification(@RequestBody VerifyHasCertificationDTO verifyHasCertificationDTO) {
        boolean hasCertification = verifyCertificationsService.validateCertification(verifyHasCertificationDTO);

        return hasCertification
                ? "Usuário já tem a certificação, não pode realizar a prova!"
                : "Usuário não tem a certificação, pode realizar a prova!";
    }

}
