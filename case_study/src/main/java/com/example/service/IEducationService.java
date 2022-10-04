package com.example.service;

import com.example.model.employee.EducationDegree;

import java.util.List;

public interface IEducationService {
    List<EducationDegree> findAll();
}
