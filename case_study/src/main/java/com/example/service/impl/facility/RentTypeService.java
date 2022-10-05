package com.example.service.impl.facility;

import com.example.model.facility.RentType;
import com.example.repository.facility.IRentTypeRepository;
import com.example.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository repository;

    @Override
    public List<RentType> findAll() {
        return repository.findAll();
    }
}
