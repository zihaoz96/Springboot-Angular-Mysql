package com.example.demo.application.service;

import com.example.demo.application.port.StaffService;
import com.example.demo.domain.entity.Staff;
import com.example.demo.domain.port.StaffRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffServiceImpl implements StaffService {
    private final StaffRepositoryPort staffRepositoryPort;

    @Autowired
    public StaffServiceImpl(StaffRepositoryPort staffRepositoryPort) {
        this.staffRepositoryPort = staffRepositoryPort;
    }

    @Override
    public Optional<List<Staff>> getAllStaffByPage(int page, int numberPerPage) {
        return staffRepositoryPort.getAllStaffByPage(page, numberPerPage);
    }

    @Override
    public Optional<Staff> getStaffById(int id) {
        return staffRepositoryPort.getStaffById(id);
    }
}
