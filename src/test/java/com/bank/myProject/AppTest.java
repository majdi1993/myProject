package com.bank.myProject;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AppTest {

	// instance bank account to this class
	private BankAccount bankAccount;

	// constarctor of this class and inject bank account to use it
	public AppTest() {
		bankAccount = new BankAccount();
	}

	// first case of test (DEPOSIT)
	@Test
	public void testDeposit() {
		// diposit an amount to the account
		bankAccount.deposit(new BigDecimal("130.75"));
		// check if the same value
		Assertions.assertEquals(new BigDecimal("130.75"), bankAccount.getAllTransactions().get(0).getAmount());
		// check if the balance is correct after transaction deposit
		Assertions.assertEquals(new BigDecimal("130.75"), bankAccount.getAllTransactions().get(0).getBalance());
	}

	// second case of test (WITHDRAWAL)
	@Test
	public void testWithdraw() {
		// diposit an amount to the account
		bankAccount.deposit(new BigDecimal("250.00"));
		// withdraw an amount to the account
		bankAccount.withdraw(new BigDecimal("100.75"));
		// check if the same value
		Assertions.assertEquals(new BigDecimal("100.75"), bankAccount.getAllTransactions().get(1).getAmount());
		// check if the balance is correct after transaction withdrawal
		Assertions.assertEquals(new BigDecimal("149.25"), bankAccount.getAllTransactions().get(1).getBalance());
	}

	// third case of test (GETALLTRANSACTIONS)
	@Test
	public void testGetAllTransactions() {
		// affect deposit and withdraw to an account
		bankAccount.deposit(new BigDecimal("100.00"));
		bankAccount.withdraw(new BigDecimal("50.00"));
		bankAccount.deposit(new BigDecimal("75.50"));

		// get history of an account
		List<Transaction> accountStatement = bankAccount.getAllTransactions();

		// verify if the numbers of transactions are correct
		Assertions.assertEquals(3, accountStatement.size());

		// verify details of the first transaction is correct or not (DEPOSIT)
		Transaction firstTransaction = accountStatement.get(0);
		Assertions.assertEquals(TransactionType.DEPOSIT, firstTransaction.getType());
		Assertions.assertEquals(new BigDecimal("100.00"), firstTransaction.getAmount());
		Assertions.assertEquals(new BigDecimal("100.00"), firstTransaction.getBalance());

		// verify details of the second transaction is correct or not (WITHDRAWAL)
		Transaction secondTransaction = accountStatement.get(1);
		Assertions.assertEquals(TransactionType.WITHDRAWAL, secondTransaction.getType());
		Assertions.assertEquals(new BigDecimal("50.00"), secondTransaction.getAmount());
		Assertions.assertEquals(new BigDecimal("50.00"), secondTransaction.getBalance());

		// verify details of the third transaction is correct or not (DEPOSIT)
		Transaction thirdTransaction = accountStatement.get(2);
		Assertions.assertEquals(TransactionType.DEPOSIT, thirdTransaction.getType());
		Assertions.assertEquals(new BigDecimal("75.50"), thirdTransaction.getAmount());
		Assertions.assertEquals(new BigDecimal("125.50"), thirdTransaction.getBalance());
	}

}
