package com.example.service;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IFacilityService {
    Page<Facility> findALl(Pageable pageable,String name);

    Optional<Facility> findById(int id);

    void save(Facility facility);

    void remove(int id);
}
