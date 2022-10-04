package com.example.service.impl.employee;

import com.example.model.employee.Division;
import com.example.repository.employee.IDivisionRepository;
import com.example.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    IDivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
