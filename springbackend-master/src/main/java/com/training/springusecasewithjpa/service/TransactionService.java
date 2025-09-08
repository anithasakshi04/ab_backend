package com.training.springusecasewithjpa.service;

import com.training.springusecasewithjpa.entities.Transaction;
import com.training.springusecasewithjpa.dao.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getTransactionsForAccount(String accountNo) {
        return transactionRepository.findByAccount_AccountNumber(accountNo);
    }

    public BigDecimal getTotalDebitsForAccount(String accountNo) {
        List<Transaction> txns = transactionRepository.findByAccount_AccountNumber(accountNo);
        return txns.stream()
                .filter(t -> "DEBIT".equalsIgnoreCase(t.getType()) && "Approved".equalsIgnoreCase(t.getStatus()))
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}