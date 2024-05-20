package com.example.it_one.controllers;

import com.example.it_one.models.Wallet;
import com.example.it_one.repositories.WalletRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController("")
public class WalletController {

    private final WalletRepository walletRepository;

    public WalletController(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @GetMapping("/wallet/create")
    public Wallet fillDB() {
        Wallet wallet = new Wallet();
        wallet.setId(1L);
        wallet.setTitle("TEST1");
        wallet.setSum(5000);
        walletRepository.save(wallet);
        return wallet;
    }

    @GetMapping("/get/wallet/{id}")
    public Optional<Wallet> getWalletDetails (
            @PathVariable Long id
    ) {
        Optional<Wallet> wallet = walletRepository.findById(id);
        return wallet;
    }

    @GetMapping("transaction/make/{sum}/{id}")
    public Object make_transaction(
            @PathVariable Integer sum, @PathVariable Long id
    ) {
        Optional<Wallet> optionalWallet = walletRepository.findById(id);

        if (optionalWallet.isPresent()) {
            Wallet wallet = optionalWallet.get();
            wallet.minusSum(sum);
            walletRepository.save(wallet);

            return "Transaction successful. New balance: " + wallet.getSum();
        } else {
            return "Wallet not found";
        }
    }

}
