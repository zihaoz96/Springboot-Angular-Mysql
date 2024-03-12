package com.example.demo.infrastructure.repository;

import com.example.demo.domain.entity.Staff;
import com.example.demo.domain.port.StaffRepositoryPort;
import com.example.demo.infrastructure.repository.jpa.StaffJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StaffRepository implements StaffRepositoryPort {
    private final StaffJpaRepository staffJpaRepository;

    @Autowired
    public StaffRepository(StaffJpaRepository staffJpaRepository) {
        this.staffJpaRepository = staffJpaRepository;
    }

    @Override
    public Optional<List<Staff>> getAllStaffByPage(int page, int numberPerPage) {
        return Optional.of(staffJpaRepository.findAll());
    }

    @Override
    public Optional<Staff> getStaffById(int id) {
        return staffJpaRepository.findById(id);
    }
}
