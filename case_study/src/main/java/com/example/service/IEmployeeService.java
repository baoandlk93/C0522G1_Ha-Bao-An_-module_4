package com.example.service;

import com.example.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService {

    Page<Employee> findAll(Pageable pageable, String name);

    void save(Employee employee);

    void remove(int id);

    Optional<Employee> findById(int id);
}
