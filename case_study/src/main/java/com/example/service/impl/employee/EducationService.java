package com.example.service.impl.employee;

import com.example.model.employee.EducationDegree;
import com.example.repository.employee.IEducationRepository;
import com.example.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService implements IEducationService {
    @Autowired
    private IEducationRepository educationRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationRepository.findAll();
    }


}
