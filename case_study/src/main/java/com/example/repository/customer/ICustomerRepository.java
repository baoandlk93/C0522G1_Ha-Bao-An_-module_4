package com.example.repository.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Modifying
    @Query(value = "update Customer set is_delete = 1 where id =:id",nativeQuery = true)
    void deleteCustomer(int id);

    @Query(value = "select * from Customer  where Customer.name like %:name% and   is_delete = 0  ",nativeQuery = true)
    Page<Customer> findAllCustomer(Pageable pageable,String name);
}
