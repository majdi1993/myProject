package com.bank.myProject;

import java.math.BigDecimal;

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

	// first case of test (WITHDRAW)
	@Test
	public void testWithdraw() {
		// diposit an amount to the account
		bankAccount.deposit(new BigDecimal("250.00"));
		// withdraw an amount to the account
		bankAccount.withdraw(new BigDecimal("100.75"));
		// check if the same value
		Assertions.assertEquals(new BigDecimal("100.75"), bankAccount.getAllTransactions().get(1).getAmount());
		// check if the balance is correct after transaction withdraw
		Assertions.assertEquals(new BigDecimal("149.25"), bankAccount.getAllTransactions().get(1).getBalance());
	}

}
