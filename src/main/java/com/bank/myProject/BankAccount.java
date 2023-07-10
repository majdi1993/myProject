package com.bank.myProject;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Majdi LABIDI
 */
public class BankAccount {
	// balance account
	private BigDecimal balance;
	// list of transactions by account
	private List<Transaction> transactions;

	// constructor of class bank account
	public BankAccount() {
		balance = BigDecimal.ZERO;
		transactions = new ArrayList<>();
	}

	// function deposit account
	public void deposit(BigDecimal amount) {
		// test if input amount <= 0
		if (amount.compareTo(BigDecimal.ZERO) <= 0) {
			// throw an exception because the amount equals or less to zero and exit
			throw new IllegalArgumentException("Invalid deposit amount");
		}
		// else
		// add amount to balance of account
		balance = balance.add(amount);
		// add transction to the list of transactions by account with transaction type
		// DEPOSIT
		transactions.add(new Transaction(TransactionType.DEPOSIT, LocalDateTime.now(), amount, balance));
	}

	// function withdraw account
	public void withdraw(BigDecimal amount) {
		// throw an exception because the amount equals or less to zero or balance less
		// to amount and exit
		if (amount.compareTo(BigDecimal.ZERO) <= 0 || amount.compareTo(balance) > 0) {
			throw new IllegalArgumentException("Invalid withdrawal amount");
		}
		// else
		// subtract amount to balance of account
		balance = balance.subtract(amount);
		// add transction to the list of transactions by account with transaction type
		// WITHDRAWAL
		transactions.add(new Transaction(TransactionType.WITHDRAWAL, LocalDateTime.now(), amount, balance));
	}

	// function to get all transactions account
	public List<Transaction> getAllTransactions() {
		return transactions;
	}

	// function print Statement
	public void printStatement() {
		System.out.println("*************** Statement Account ***************");
		System.out.println("Date\t\t\t\tAmount\tBalance");
		for (Transaction transaction : transactions) {
			System.out
					.println(transaction.getDate() + "\t\t" + transaction.getAmount() + "\t" + transaction.getBalance());
		}
	}
}