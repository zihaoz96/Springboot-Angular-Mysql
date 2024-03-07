package com.example.demo.staffTests;

import com.example.demo.domain.model.Staff;
import com.example.demo.domain.service.StaffService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class staffTests {

    @Autowired
    private StaffService staffService;

    @Test
    public void getAllStaffTest(){
        List<Staff> staffList = staffService.getAllStaffByPage(0, 10);
        staffList.forEach(s -> System.out.println(s.toString()));
        System.out.println(staffList.size());
    }

    @Test
    public void getStaffByIdTest(){
        Optional<Staff> staff = staffService.getStaffById(2);
        staff.ifPresent(value -> System.out.println(value.toString()));
    }

    @Test
    public void getStaffByIdWrongTest(){
        Optional<Staff> staff = staffService.getStaffById(200);
        if(staff.isPresent()){
            System.out.println(staff.get().toString());
        }else{
            System.out.println("Not found");
        }
    }
}
