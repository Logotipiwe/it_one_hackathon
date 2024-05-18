package com.example.it_one.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;


@Data
@Entity
public class Transaction {
    @Id
    private Long id;
    private Integer userID;
    private Integer sum;
    private String category;
    private Date date;
}
