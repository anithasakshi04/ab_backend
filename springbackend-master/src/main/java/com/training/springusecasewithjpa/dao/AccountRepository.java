package com.training.springusecasewithjpa.dao;


import com.training.springusecasewithjpa.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    // no extra methods needed for now
}