package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bank {
	// Variable for logging/not logging
	private static final boolean LOG = true;

	private static int accountCounter = 1;
	private String name;
	private ArrayList<Account> accounts;

	public Bank() {
		this("Bank Name");
	}

	public Bank(String name) {
		this.name = name;
		accounts = new ArrayList<>();
		log("Bank created");
	}

	public int createAccount(String name) {
		Account newAccount = new Account(name);
		accounts.add(newAccount);

		log("Added account " + newAccount);
		return newAccount.accountNumber;
	}

	public boolean closeAccount(int accountNumber) {
		Account account = findAccount(accountNumber);
		if (account == null) {
			log("Could not close account " + accountNumber);
			return false;
		}
		accounts.remove(account);
		log("Successfully closed " + account);
		return true;
	}

	public boolean deposit(int accountNumber, int amount, boolean test) {
		Account account = findAccount(accountNumber);
		if (!test)
		{
		if (account == null) {
			log("Could not deposit to account " + accountNumber);
			return false;
		}
		account.balance += amount;
		log("Successfully deposited $" + amount + " to " + account);
		return true;
		}
		else
		{
			if (account == null) {
				log("Could not deposit to account " + accountNumber);
				return false;
			}
			return true;
		}
	}

	public boolean withdraw(int accountNumber, int amount, boolean test) {
		Account account = findAccount(accountNumber);
		if (!test)
		{
		if (account == null) {
			log("Could not withdraw from account " + accountNumber);
			return false;
		}
		if (account.balance < amount) {
			log("Insufficient funds in " + account);
			return false;
		}
		account.balance -= amount;
		log("Successfully withdrew $" + amount + " from " + account);
		return true;
		}
		else
		{
			if (account == null) {
				log("Could not withdraw from account " + accountNumber);
				return false;
			}
			if (account.balance < amount) {
				log("Insufficient funds in " + account);
				return false;
			}
			return true;
		}
	}

	public int checkBalance(int accountNumber) {
		Account account = findAccount(accountNumber);
		if (account == null) {
			log("Could not check balance of account " + accountNumber);
			return -1;
		}
		log("Successfully checked balance of account " + account);
		return account.balance;
	}

	public void saveAccounts(String filename) {
		try {
			
			FileWriter fw = new FileWriter(filename);
			
			for (int i = 0; i < accounts.size(); i ++)
			{
				fw.append("Name: " + accounts.get(i).name + "\n");
				fw.append("Account Number: " + accounts.get(i).accountNumber + "\n");
				fw.append("Balance: $" + accounts.get(i).balance + "\n");
				fw.append("\n");
			}
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		log("Successfully saved accounts to Accounts.txt");
	}

	public void loadAccounts(String filename) {

		try {
			File inputFile = new File("Accounts.txt");
			Scanner fileIn = new Scanner(inputFile);
			while (fileIn.hasNextLine())
			{
			String nameLine = fileIn.nextLine();
			String acctNoLine = fileIn.nextLine();
			String balanceLine = fileIn.nextLine();
			fileIn.nextLine();
			String name = nameLine.substring(6);
			int acctNo = Integer.parseInt(acctNoLine.substring(16));
			int balance = Integer.parseInt(balanceLine.substring(10));
			Account acct = new Account(name, acctNo, balance);
			accounts.add(acct);
			}
			
			fileIn.close();
			log("Successfully loaded existing accounts");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Account findAccount(int accountNumber) {
		for (int i = accounts.size() - 1; i >= 0; i--) {
			if (accounts.get(i).accountNumber == accountNumber)
				return accounts.get(i);
		}
		return null;
	}

	private void log(String message) {
		if (LOG)
			System.out.println(name + " ::: " + message + ".");
	}

	/**
	 * Private Inner Class Account
	 * Deals with Account information
	 */
	private class Account {
		int accountNumber;
		String name;
		int balance;

		private Account(String name) {
			this.name = name;
			balance = 0;
			accountNumber = accountCounter++;
		}
		
		private Account(String name, int accountNumber, int balance) {
			this.name = name;
			this.accountNumber = accountNumber;
			this.balance = balance;
			if (accountNumber > accountCounter)
				accountCounter = accountNumber + 1;
		}

		public String toString() {
			return "{" + accountNumber + "::" + name + "::$" + balance + "}";
		}

	}
}
