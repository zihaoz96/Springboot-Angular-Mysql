package com.example.demo.domain.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Optional;

@Entity
@Getter
@Setter
@Slf4j
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double livretA;
    private Double current;


    public Account() {
    }

    public Account(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", livretA=" + livretA +
                ", current=" + current +
                '}';
    }

    public Optional<Object> getFieldValue(String fieldName)  {
        try {
            Field field = getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return Optional.ofNullable(field.get(this));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            log.error(e.getMessage());
            return Optional.empty();
        }
    }

    public void setFieldValue(String fieldName, double value) {
        try{
            Field field = getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(this, value);
        }catch (NoSuchFieldException | IllegalAccessException e) {
            log.error(e.getMessage());
        }
    }
}
