package com.example.repository.facility;

import com.example.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IFacilityRepository extends JpaRepository<Facility,Integer> {

    @Query(value = "select * from Facility where Facility.name like %:name% and is_delete = 0", nativeQuery = true)
    Page<Facility> findAll(Pageable pageable, String name);

    @Modifying
    @Query(value = "update Facility set is_delete = 1 where id =:id",nativeQuery = true)
    void deleteFacility(int id);
}
