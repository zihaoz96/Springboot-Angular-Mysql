package com.example.demo.adapter.persistence;

import com.example.demo.domain.model.Staff;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository {
    Staff getStaffById(Integer id);
}
