package com.example.demo.infrastructure.web.controller;

import com.example.demo.application.port.StaffService;
import com.example.demo.infrastructure.web.response.AjaxResponse;
import com.example.demo.domain.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
public class StaffController {

    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping(value = "/staff", produces = MediaType.APPLICATION_JSON_VALUE)
    public AjaxResponse getAllStaff(@RequestParam Integer page, @RequestParam Integer numberPerPage){
        try{
            Optional<List<Staff>> staffList = staffService.getAllStaffByPage(page, numberPerPage);
            if(staffList.isPresent()){
                return AjaxResponse.success("Get staff success "+page, staffList);
            }

            return AjaxResponse.success("No staff found ");

        }catch (Exception e){
            e.printStackTrace();

            return AjaxResponse.failed("Failed get list staff");
        }
    }

    @GetMapping(value = "/staff/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AjaxResponse getStaffById(@PathVariable Integer id){
        try {
            Optional<Staff> staff = staffService.getStaffById(id);
            if(staff.isPresent()){
                return AjaxResponse.success(
                        "Get staff id:" + id + " success",
                        staff.get()
                        );
            }

            return AjaxResponse.failed("Failed get staff with id:" + id);
        }catch (Exception e){
            e.printStackTrace();

            return AjaxResponse.failed("Failed get staff with id:" + id);
        }
    }
}
