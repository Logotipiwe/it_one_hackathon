package com.example.it_one.controllers;

import com.example.it_one.models.Wallet;
import com.example.it_one.repositories.WalletRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("/api/wallets")
public class WalletController {

    private final WalletRepository walletRepository;

    public WalletController(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @GetMapping("/create")
    public Wallet fillDB() {
        Wallet wallet = new Wallet();
        wallet.setId(1L);
        wallet.setTitle("TEST1");
        wallet.setSum(5000);
        walletRepository.save(wallet);
        return wallet;
    }

    @GetMapping("/get/wallet/{id}")
    public Optional<Wallet> getWalletDetails(@RequestParam(name = "id") Long id) {
        Optional<Wallet> wallet = walletRepository.findById(id);
        return wallet;
    }
}
