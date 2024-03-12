package com.example.demo.domain.port;

import com.example.demo.domain.entity.Staff;

import java.util.List;
import java.util.Optional;

/**
 * 出站端口
 *
 */
public interface StaffRepositoryPort {
    Optional<List<Staff>> getAllStaffByPage(int page, int numberPerPage);
    Optional<Staff> getStaffById(int id);
}
