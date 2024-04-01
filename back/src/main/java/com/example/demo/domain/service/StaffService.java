package com.example.demo.domain.service;

import com.example.demo.domain.entity.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffService {
    Optional<List<Staff>> getAllStaffByPage(int page, int numberPerPage);
    Optional<Staff> getStaffById(int id);
}
