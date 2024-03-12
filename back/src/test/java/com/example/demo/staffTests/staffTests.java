package com.example.demo.staffTests;

import com.example.demo.application.port.StaffService;
import com.example.demo.domain.entity.Staff;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class staffTests {

    @Autowired
    private StaffService staffService;

    @Test
    public void getAllStaffTest(){
        Optional<List<Staff>> staffList = staffService.getAllStaffByPage(0, 10);
        assertTrue(staffList.isPresent());
        staffList.ifPresent(list -> list.forEach(s -> System.out.println(s.toString())));
    }

    @Test
    public void getStaffByIdCorrectTest(){
        Optional<Staff> staff = staffService.getStaffById(2);
        assertTrue(staff.isPresent());
        staff.ifPresent(value -> System.out.println(value.toString()));
    }

    @Test
    public void getStaffByIdInCorrectTest(){
        Optional<Staff> staff = staffService.getStaffById(3333);
        assertFalse(staff.isPresent());
        staff.ifPresent(value -> System.out.println(value.toString()));
    }

}
