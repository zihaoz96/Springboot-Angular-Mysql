package com.example.demo.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Staff {

    @Id
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
