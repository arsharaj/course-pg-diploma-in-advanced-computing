package com.banking;

import static java.lang.Thread.*;

public class JointAccount {
	private double balance;

	public JointAccount(double balance) {
		super();
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [balance=" + balance + "]";
	}

	// update balance orig bal =10000 n amt=500
	public  synchronized void   updateBalance(double amt) throws Exception {
		System.out.println("Updating bal : " + currentThread().getName());
		balance = balance + amt;//10500
		System.out.println("Cancelling updates, after a delay");
		Thread.sleep(17);//simulates think time of user | context switching
		balance = balance - amt;//10000
		System.out.println("Updations over by " + currentThread().getName());
	}//10,000

	// chk balance
	public synchronized double checkBalance() throws Exception {
		System.out.println("Checking balance : by " + currentThread().getName());
		Thread.sleep(37);
		return balance;

	}

}
