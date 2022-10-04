package com.example.service.impl.employee;

import com.example.model.employee.Employee;
import com.example.repository.employee.IEmployeeRepository;
import com.example.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable, String name) {
        return employeeRepository.findAllEmployee(pageable,name);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(int id) {
        employeeRepository.deleteEmployee(id);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }
}
