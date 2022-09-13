package com.codegym.repository;

import com.codegym.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalDeclarationRepository {
    List<MedicalDeclaration> displayAll();

    MedicalDeclaration finById(int id);

    MedicalDeclaration edit(MedicalDeclaration medicalDeclaration);

    List<Integer> dateList();

    List<String> genderList();

    List<String> countryList();

    List<String> travelInfo();


}
