package com.example.demo.port.persistence;

import com.example.demo.adapter.persistence.StaffRepository;
import com.example.demo.domain.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffJpaRepository extends JpaRepository<Staff, Integer>, StaffRepository {

    @Override
    Staff getStaffById(Integer id);
}
