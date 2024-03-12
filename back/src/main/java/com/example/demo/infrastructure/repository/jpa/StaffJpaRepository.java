package com.example.demo.infrastructure.repository.jpa;

import com.example.demo.domain.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaffJpaRepository extends JpaRepository<Staff, Integer> {

    @Override
    Optional<Staff> findById(Integer integer);

    @Override
    <S extends Staff> List<S> saveAll(Iterable<S> entities);
}
