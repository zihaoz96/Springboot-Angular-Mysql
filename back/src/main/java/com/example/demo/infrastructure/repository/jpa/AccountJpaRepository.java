package com.example.demo.infrastructure.repository.jpa;

import com.example.demo.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountJpaRepository extends JpaRepository<Account, Integer> {
    @Override
    Optional<Account> findById(Integer integer);

    @Override
    <S extends Account> List<S> saveAll(Iterable<S> entities);
}
