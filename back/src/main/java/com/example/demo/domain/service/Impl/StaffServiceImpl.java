package com.example.demo.domain.service.Impl;

import com.example.demo.domain.entity.Staff;
import com.example.demo.domain.repository.StaffRepository;
import com.example.demo.domain.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;

    @Autowired
    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public Optional<List<Staff>> getAllStaffByPage(int page, int numberPerPage) {
        return staffRepository.getAllStaffByPage(page, numberPerPage);
    }

    @Override
    public Optional<Staff> getStaffById(int id) {
        return staffRepository.getStaffById(id);
    }
}
