package com.banking;

public enum AccountType {
	SAVING(10000),CURRENT(5000),FD(50000);
	private int minBalance;

	private AccountType(int minBalance) {
		//super(name, ordinal);
		this.minBalance = minBalance;
	}

	public int getMinBalance() {
		return minBalance;
	}	
}
