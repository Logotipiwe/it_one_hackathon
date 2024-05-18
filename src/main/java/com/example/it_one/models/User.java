package com.example.it_one.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    private Long id;
    private String firstname;
    private Integer age;
}
