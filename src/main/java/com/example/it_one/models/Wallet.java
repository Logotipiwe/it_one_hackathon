package com.example.it_one.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Wallet {
    @Id
    private Long id;
    private String title;
    private Integer sum;

}
