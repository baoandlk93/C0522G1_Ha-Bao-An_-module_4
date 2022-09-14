package com.codegym.service;

import com.codegym.model.MedicalDeclaration;
import com.codegym.repository.IMedicalDeclarationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalDeclarationService implements IMedicalDeclarationService {
    @Autowired
    IMedicalDeclarationRepository declarationRepository;

    @Override
    public List<MedicalDeclaration> displayAll() {
        return declarationRepository.displayAll();
    }

    @Override
    public MedicalDeclaration finById(int id) {
        return declarationRepository.finById(id);
    }

    @Override
    public MedicalDeclaration edit(MedicalDeclaration medicalDeclaration) {
        return declarationRepository.edit(medicalDeclaration);
    }

    @Override
    public List<Integer> dateList() {
        return declarationRepository.dateList();
    }

    @Override
    public List<String> genderList() {
        return declarationRepository.genderList();
    }

    @Override
    public List<String> countryList() {
        return declarationRepository.countryList();
    }

    @Override
    public List<String> travelInfo() {
        return declarationRepository.travelInfo();
    }
}
