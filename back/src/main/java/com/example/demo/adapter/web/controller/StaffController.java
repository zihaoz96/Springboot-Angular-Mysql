package com.example.demo.adapter.web.controller;

import com.example.demo.application.AjaxResponse;
import com.example.demo.domain.model.Staff;
import com.example.demo.domain.service.StaffService;
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

    @GetMapping("numberStaff")
    public AjaxResponse getNumberOfStaff(){
        try{
            long size = staffService.getNumberOfStaff();

            return AjaxResponse.success("Get number of staff success", size);
        }catch (Exception e){
            e.printStackTrace();

            return AjaxResponse.failed("Failed get number of staff");
        }
    }

    @GetMapping(value = "/staff", produces = MediaType.APPLICATION_JSON_VALUE)
    public AjaxResponse getAllStaff(@RequestParam Integer page, @RequestParam Integer numberPerPage){
        try{
            List<Staff> staffList = staffService.getAllStaffByPage(page, numberPerPage);

            return AjaxResponse.success("Get staff success "+page, staffList);
        }catch (Exception e){
            e.printStackTrace();

            return AjaxResponse.failed("Failed get list staff");
        }
    }

    @GetMapping(value = "/staff/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AjaxResponse getAllStaff(@PathVariable Integer id){
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
