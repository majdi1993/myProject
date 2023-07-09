package com.bank.myProject;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Majdi LABIDI
*/
public class Transaction {
	
	// all variables of one transaction
    private TransactionType type;
    private LocalDateTime date;
    private BigDecimal amount;
    private BigDecimal balance;
    
    //constructor with all parameters 
    public Transaction(TransactionType type, LocalDateTime date, BigDecimal amount, BigDecimal balance) {
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }
    
    //getters and setters
	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

   
}
