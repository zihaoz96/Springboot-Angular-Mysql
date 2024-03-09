package com.example.demo.domain.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.Optional;

@Entity
@Getter
@Setter
public class Account {
    @Id
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
            e.printStackTrace();
            return Optional.empty();
        }
    }

    // 设置对象指定字段的值
    public void setFieldValue(String fieldName, double value) {
        try{
            Field field = getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(this, value);
        }catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
