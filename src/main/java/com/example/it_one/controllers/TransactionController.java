package com.example.it_one.controllers;


import com.example.it_one.models.Transaction;
import com.example.it_one.models.Wallet;
import com.example.it_one.repositories.TransactionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController("")
public class TransactionController {

    private final TransactionRepository transactionRepo;

    public TransactionController(TransactionRepository transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    @GetMapping("transaction/create")
    public Transaction fillDB() {
        java.time.LocalDateTime currentTime = java.time.LocalDateTime.now();

        Transaction transaction = new Transaction();
        transaction.setId(0L);
        transaction.setUserId(0);
        transaction.setSum(500);
        transaction.setCategory("Food");
        transaction.setDate(currentTime);
        transactionRepo.save(transaction);
        return transaction;
    }

    @GetMapping("transaction/get/{id}")
    public Optional<Transaction> get_transaction_by_id (
            @PathVariable Long id
    ) {
        Optional<Transaction> transaction = transactionRepo.findAllById(id);
        return transaction;
    }

    @GetMapping("get/user/transaction/{userId}")
    public Object get_transaction_by_id (
            @PathVariable Integer userId
//            @RequestParam Integer userID, LocalDate date
    ) {

        Optional<List<Transaction>> transaction = transactionRepo.findAllByUserId(userId);
        return transaction;
    }
}
