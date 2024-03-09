package com.example.demo.domain.service;

import com.example.demo.domain.model.Staff;
import com.example.demo.port.persistence.StaffJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StaffService {

    @Autowired
    private StaffJpaRepository staffRepository;

    public long getNumberOfStaff(){
        return staffRepository.count();
    }

    public List<Staff> getAllStaffByPage(int page, int numberPerPage){
        Page<Staff> staffPage = staffRepository.findAll(PageRequest.of(page, numberPerPage));
        return staffPage.getContent();
    }

    public Optional<Staff> getStaffById(int id){
        return Optional.of(staffRepository.getStaffById(id));
    }
}
