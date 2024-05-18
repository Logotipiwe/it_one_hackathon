package com.example.it_one.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
public class Transaction {
    @Id
    private Long id;
    private Integer userId;
    private Integer sum;
    private String category;
    private LocalDateTime date;
}
