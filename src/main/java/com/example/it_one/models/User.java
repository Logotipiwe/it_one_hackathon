package com.example.it_one.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_wallet_id")
    private Wallet userWallet;

    private String firstname;
    private String lastname;
    private String email;
    private String password;

}
