package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import core.Statement;

public class Utils {

	public static double sumOfAllDeposits(ArrayList<Statement> statements) {
		return statements.stream().mapToDouble(statement -> statement.getDepositAmount()).sum();
	}

	public static double maxDepositedAmount(ArrayList<Statement> statements) {
		return statements.stream().map(statement -> statement.getDepositAmount())
				.max((statementOne, statementTwo) -> statementOne.compareTo(statementTwo)).orElseThrow();
	}

	public static double maxWithDrawlAmount(ArrayList<Statement> statements) {
		return statements.stream().map(statement -> statement.getWithdrawlAmount())
				.max((statementOne, statementTwo) -> statementOne.compareTo(statementTwo)).orElseThrow();
	}

	public static double sumOfShoppingWithdrawls(ArrayList<Statement> statements) {
		return statements.stream().filter(statement -> statement.getNarration().equals("Shopping"))
				.mapToDouble(statement -> statement.getWithdrawlAmount()).sum();
	}

	public static String getDateForMaxShopping(ArrayList<Statement> statements) {
		return statements.stream()
				.filter(statement -> Double.valueOf(statement.getWithdrawlAmount()).equals(Double.valueOf(maxWithDrawlAmount(statements))))
				.findFirst().orElseThrow().getTransactionDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
				.toString();

	}

	public static void restore(String string, ArrayList<Statement> statements) {
		try (BufferedReader br = new BufferedReader(new FileReader("Jan2023.txt"))) {
			br.readLine();
			String transactionString;
			String[] transactionDetails;
			while ((transactionString = br.readLine()) != null) {
				transactionDetails = transactionString.split(",");
				statements.add(
						new Statement(LocalDate.parse(transactionDetails[0], DateTimeFormatter.ofPattern("dd-MM-yyyy")),
								transactionDetails[1], Double.parseDouble(transactionDetails[2]),
								Double.parseDouble(transactionDetails[3])));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Statements restored from a file.");
	}

	public static void store(String string, ArrayList<Statement> statements) {
		try (PrintWriter pw = new PrintWriter(new FileWriter("Jan2023.txt"))) {
			pw.write("TransactionDate,Narration,WithdrawalAmount,DepositAmount\n");
			statements.forEach(statement -> pw.println(statement));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Statements stored into a file.");
	}

	public static void displayAllTransactions(ArrayList<Statement> statements) {
		statements.forEach(transaction -> System.out.println(transaction));
	}

}
