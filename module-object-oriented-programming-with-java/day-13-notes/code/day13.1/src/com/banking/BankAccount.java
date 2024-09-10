package com.banking;

import java.time.LocalDate;

import custom_exceptions.InsufficientBalanceException;

import static utils.BankingRules.validateBalance;

/*
 * BankAccount : acctNo, customer name ,
 *  type(enum :SAVING(10000),CURRENT(5000),FD(50000))  , 
 *  balance , creation date , last tx date , isActive
 */
public class BankAccount {
	private int acctNo;
	private String customerName;
	private AccountType acType;
	private int balance;
	private LocalDate creationDate;
	private LocalDate lastTxDate;
	private boolean active;

	public BankAccount(int acctNo, String customerName, AccountType acType, int balance, LocalDate creationDate) {
		super();
		this.acctNo = acctNo;
		this.customerName = customerName;
		this.acType = acType;
		this.balance = balance;
		this.creationDate = creationDate;
		this.lastTxDate = LocalDate.of(creationDate.getYear(), creationDate.getMonth(), creationDate.getDayOfMonth());
		this.active = true;
	}

	@Override
	public String toString() {
		return "BankAccount [acctNo=" + acctNo + ", customerName=" + customerName + ", acType=" + acType + ", balance="
				+ balance + ", creationDate=" + creationDate + ", lastTxDate=" + lastTxDate + ", active=" + active
				+ "]";
	}

	// methods
	public void deposit(int amount) {
		this.balance += amount;
	}

	public void withdraw(int amount) throws InsufficientBalanceException {
		validateBalance(balance - amount, this.acType);
		this.balance -= amount;
	}

	// transfer
	public void fundsTransfer(BankAccount dest, int transferAmount) throws InsufficientBalanceException {
		// this => src acct
		this.withdraw(transferAmount);
		dest.deposit(transferAmount);
	}

	public int getAcctNo() {
		return acctNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public AccountType getAcType() {
		return acType;
	}

	public int getBalance() {
		return balance;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public LocalDate getLastTxDate() {
		return lastTxDate;
	}

	public boolean isActive() {
		return active;
	}
	

}
