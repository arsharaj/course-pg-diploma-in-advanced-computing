package tester;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.banking.AccountType;
import com.banking.BankAccount;

import custom_exceptions.BankingException;

import static utils.BankingRules.*;

/*
 * Options
1. Open new account
2. Get Account summary
3. Withdraw/deposit
4. Transfer Funds
5. Close Account
 */
public class TestCoreBanking {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create D.S
			Map<Integer, BankAccount> accts = new HashMap<>();
			boolean exit = false;
			while (!exit) {
				System.out.println("Options : 1. Open a/c 2. Get a/c summary 0.Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter a/c no");
						int validAcNo = checkForDup(sc.nextInt(), accts);
						// => new a/c no
						System.out.println("Enter  customerName,  acType,  balance,  creationDate");
						BankAccount account = validateAllInputs(validAcNo, sc.next(), sc.next(), sc.nextInt(),
								sc.next());
						// store a/c details in the map
						accts.put(validAcNo, account);
						System.out.println("a/c created...");
						break;
					case 2: // get a/c summary
						System.out.println("Enter a/c no");
						account = accts.get(sc.nextInt());// auto boxing
						if (account == null)
							throw new BankingException("Invalid a/c no !!!!!!!!!!!!!!!");
						System.out.println(account);
					case 3:// transfer
						System.out.println("Enter src a/c , dest a/c no n amount");
						BankAccount src = accts.get(sc.nextInt());
						if (src == null)
							throw new BankingException("Invalid src a/c no !!!!!!!!!!!!!!!");
						BankAccount dest = accts.get(sc.nextInt());
						if (dest == null)
							throw new BankingException("Invalid dest a/c no !!!!!!!!!!!!!!!");
						// src n dest a/c exist
						src.fundsTransfer(dest, sc.nextInt());
						System.out.println("funds transferred updated src bal " + src.getBalance() + " dest bal "
								+ dest.getBalance());
						break;
					case 4:// close a/c
						System.out.println("Enter a/c no to close a/c");
						account = accts.remove(sc.nextInt());// int ---> Integer
						if (account == null)
							throw new BankingException("Invalid a/c no , closing a/c failed !!!!!");
						System.out.println("Closed the a/c of " + account.getCustomerName());
						break;

					case 5:
						System.out.println("Bank Accounts in the bank");
						// System.out.println(accts);//{101=BankAccount 101 abc....,
						// 10=....,40=....}
						for (BankAccount a : accts.values())
							System.out.println(a);
						// display : un sorted n un ordered : HashMap
						break;

					case 6:
						System.out.println("Bank a/c details sorted as per asc a/c no");
						// sorting criteria : ac no --key based ? YES : sorted map : TreeMap
						TreeMap<Integer, BankAccount> sortedMap = new TreeMap<>(accts);
						// JVM invokes : TimSort : Integer's compareTo (Natural ordering)
						for (BankAccount a : sortedMap.values())
							System.out.println(a);
						break;

					case 0:
						exit = true;
						break;

					}
				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}

	}

}
