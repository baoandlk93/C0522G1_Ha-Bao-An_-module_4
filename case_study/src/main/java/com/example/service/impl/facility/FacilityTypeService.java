package com.example.service.impl.facility;

import com.example.model.facility.FacilityType;
import com.example.repository.facility.IFacilityTypeRepository;
import com.example.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository repository;

    @Override
    public List<FacilityType> findAll() {
        return repository.findAll();
    }
}
