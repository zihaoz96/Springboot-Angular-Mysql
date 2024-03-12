package com.example.demo.initialDatabase;


import com.example.demo.domain.entity.Account;
import com.example.demo.domain.entity.Staff;
import com.example.demo.domain.entity.User;
import com.example.demo.infrastructure.repository.AccountRepository;
import com.example.demo.infrastructure.repository.jpa.AccountJpaRepository;
import com.example.demo.infrastructure.repository.jpa.StaffJpaRepository;
import com.example.demo.infrastructure.repository.jpa.UserJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class InitialDatabase {

    @Autowired
    private AccountJpaRepository accountJpaRepository;

    @Autowired
    private StaffJpaRepository staffJpaRepository;

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Test
    public void AddAccountAndStaff() {
        List<Account> accounts = new ArrayList<>();
        List<Staff> staffs = new ArrayList<>();

        Random random = new Random();
        String[] firstNames = {"John", "Sarah", "Mike", "Jane", "Emily", "David", "Anna", "Chris", "Patricia", "Daniel"};
        String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez"};

        for (int i = 1; i <= 10; i++) {
            // add account
            Account account = new Account();
            account.setId(i);
            account.setLivretA(1000 + (10000 - 1000) * random.nextDouble());
            account.setCurrent(1000 + (10000 - 1000) * random.nextDouble());
            accounts.add(account);

            // add staff
            int age = 20 + random.nextInt(40);
            String email = firstNames[i].toLowerCase() + "." + lastNames[i].toLowerCase() + "@example.com";
            String phoneNumber = "123-456-" + String.format("%04d", random.nextInt(10000)); // 生成随机电话号码

            Staff staff = new Staff(i+1, firstNames[i], lastNames[i], age, phoneNumber, email, accounts.get(i));
            staffs.add(staff);
        }

        accountJpaRepository.saveAll(accounts);
        staffJpaRepository.saveAll(staffs);
    }

    @Test
    public void AddUser(){
        User user = new User("admin","admin");
        userJpaRepository.save(user);
    }

}
