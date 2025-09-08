package com.training.springusecasewithjpa.dao;

import com.training.springusecasewithjpa.entities.Batch;
import com.training.springusecasewithjpa.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    // Find transactions attached directly to an account
    List<Transaction> findByAccount_AccountNumber(String accountNumber);

    // Find transactions attached to a given batch entity
    List<Transaction> findByBatch(Batch batch);

    // Optional: fetch by batch id if needed (batch id type must match)
    // List<Transaction> findByBatch_Id(String batchId);
}
