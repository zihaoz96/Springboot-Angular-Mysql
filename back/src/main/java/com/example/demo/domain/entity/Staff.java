package com.example.demo.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String phoneNumber;
    private String email;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Staff() {}

    public Staff(Integer id, String firstName, String lastName, Integer age, String phoneNumber, String email, Account account) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.account = account;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phone='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", accoundId='" + account.getId() + '\'' +
                ", accoundCurrent='" + account.getCurrent() + '\'' +
                '}';
    }
}
