package core;

import java.time.LocalDate;

public class Statement {
	private LocalDate transactionDate;
	private String narration;
	private double withdrawlAmount;
	private double depositAmount;

	public Statement(LocalDate transactionDate, String narration, double withdrawlAmount, double depositAmount) {
		this.transactionDate = transactionDate;
		this.narration = narration;
		this.withdrawlAmount = withdrawlAmount;
		this.depositAmount = depositAmount;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public String getNarration() {
		return narration;
	}

	public double getWithdrawlAmount() {
		return withdrawlAmount;
	}

	public double getDepositAmount() {
		return depositAmount;
	}

	@Override
	public String toString() {
		return "Statement [transactionDate=" + transactionDate + ", narration=" + narration + ", withdrawlAmount="
				+ withdrawlAmount + ", depositAmount=" + depositAmount + "]";
	}
}
