package utils;

import java.time.LocalDate;
import java.util.Map;

import com.banking.AccountType;
import com.banking.BankAccount;

import custom_exceptions.BankingException;
import custom_exceptions.InsufficientBalanceException;

public class BankingRules {
//add a method to validate min balance 
	public static void validateBalance(int balance, AccountType type) throws InsufficientBalanceException {
		if (balance < type.getMinBalance())
			throw new InsufficientBalanceException("Insufficient funds !!!!!");
		System.out.println("suff bal");
	}

	// add a method for parsing n validating ac type
	public static AccountType parseAndValidateType(String acType) {
		return AccountType.valueOf(acType.toUpperCase());
	}

	// add a method for parsing date
	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}

	// add a method for validating ac no
	public static int checkForDup(int acctNo, Map<Integer, BankAccount> map) throws BankingException {
		if (map.containsKey(acctNo))
			throw new BankingException("Dup a/c no !!!!!!!!!!!!");
		// distinct a/c no
		return acctNo;
	}

	// add a static method to validate i/ps
	public static BankAccount validateAllInputs(int acNo, String customerName, String acType, int balance,
			String creationDate) throws InsufficientBalanceException {
		AccountType type = parseAndValidateType(acType);
		validateBalance(balance, type);
		LocalDate parsedDate = parseDate(creationDate);
		return new BankAccount(acNo, customerName, type, balance, parsedDate);
	}
}
