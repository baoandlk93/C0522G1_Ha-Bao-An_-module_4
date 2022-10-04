package com.example.repository.employee;

import com.example.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "select * from Employee  where Employee.name  like %:name% and   is_delete = 0  ", nativeQuery = true)
    Page<Employee> findAllEmployee(Pageable pageable, String name);

    @Modifying
    @Query(value = "update Employee set is_delete = 1 where id =:id",nativeQuery = true)
    void deleteEmployee(int id);
}
