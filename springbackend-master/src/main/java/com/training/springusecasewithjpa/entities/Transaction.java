package com.training.springusecasewithjpa.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @Column(name = "id")   // explicit PK column
    private String id;

    // link to PayrollEntry (uses its PK = id)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payroll_entry_id")   // FK column in transactions
    private PayrollEntry payrollEntry;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "type")
    private String type;      // "DEBIT" or "CREDIT"

    @Column(name = "status")
    private String status;    // e.g. "Approved"

    @Column(name = "counterparty")
    private String counterparty;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    // link to Batch (uses its PK = id)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batch_id")           // FK column in transactions
    private Batch batch;

    // link to Account (uses its PK = account_number)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_number")     // FK column in transactions
    private Account account;

    public Transaction() {}

    public Transaction(String id, BigDecimal amount, String type, String status,
                       String counterparty, LocalDateTime dateTime) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.status = status;
        this.counterparty = counterparty;
        this.dateTime = dateTime;
    }

    // Getters & setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCounterparty() { return counterparty; }
    public void setCounterparty(String counterparty) { this.counterparty = counterparty; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public PayrollEntry getPayrollEntry() { return payrollEntry; }
    public void setPayrollEntry(PayrollEntry payrollEntry) { this.payrollEntry = payrollEntry; }

    public Batch getBatch() { return batch; }
    public void setBatch(Batch batch) { this.batch = batch; }

    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }
}
