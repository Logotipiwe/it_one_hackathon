package com.example.it_one.controllers;

import com.example.it_one.models.Wallet;
import com.example.it_one.repositories.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/wallets")
public class TestController {

    private final WalletRepository walletRepository;

    public TestController(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @GetMapping("/create")
    public Wallet fillDB() {
        Wallet wallet = new Wallet();
        wallet.setId(0L);
        wallet.setTitle("TEST");
        wallet.setSum(1000);
        walletRepository.save(wallet);
        return wallet;
    }
}
