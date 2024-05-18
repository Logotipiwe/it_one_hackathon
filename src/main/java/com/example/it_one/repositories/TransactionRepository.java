package com.example.it_one.repositories;

import com.example.it_one.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Optional<Transaction> findAllById(Long id);
    Optional<List<Transaction>> findAllByUserId(Integer userId
    );
}
