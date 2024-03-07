package com.example.demo.staff;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

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
