package com.training.springusecasewithjpa.dao;

import com.training.springusecasewithjpa.entities.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepository extends JpaRepository<Batch, String> {
    // JpaRepository provides all basic CRUD operations automatically
    // You can add custom query methods here if needed
    List<Batch> findByDebitAccount(String debitAccount);

    @Query("SELECT DISTINCT b.debitAccount FROM Batch b WHERE b.debitAccount IS NOT NULL")
    List<String> findDistinctByDebitAccountIsNotNull();

}