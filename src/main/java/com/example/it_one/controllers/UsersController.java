package com.example.it_one.controllers;


import com.example.it_one.models.User;
import com.example.it_one.repositories.UserRepo;
import com.example.it_one.repositories.WalletRepository;
import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("")
public class UsersController {

    private final UserRepo userRepo;

    public UsersController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/user/create")
    public User fillDB() {
        User new_user = new User();
        new_user.setId(0L);
        new_user.setFirstname("Lev");
        new_user.setLastname("Stremilov");
        new_user.setEmail("test@gmail.com");
        new_user.setPassword("testpassword");
        userRepo.save(new_user);
        return new_user;
    }

    @GetMapping("user/get/{id}")
    public Optional<User> get_user_by_id(@PathVariable Long id) {
        Optional<User> user = userRepo.findById(id);
        return user;
    }
}
