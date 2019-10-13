package app;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		// example1();
		
		Bank bank = new Bank("The Bank");
		Scanner scan = new Scanner(System.in);
		int selection;
		boolean quit = false;
		
		do {
			System.out.println("0. Quit");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Check balance");
			System.out.println("4. Create account");
			System.out.println("5. Close Account");
			System.out.println("6. Transfer funds");
			System.out.println("7. Save Accounts");
			System.out.println("Select an option: ");
			selection = scan.nextInt();
			scan.nextLine();
			int acctno;
			int amt;
		switch (selection) {
		case 1:
			System.out.println("Enter your account number: ");
			acctno = scan.nextInt();
			System.out.println("How much would you like to deposit?");
			amt = scan.nextInt();
			bank.deposit(acctno, amt);
			break;
		case 2:
			System.out.println("Enter your account number: ");
			acctno = scan.nextInt();
			System.out.println("How much would you like to withdraw?");
			amt = scan.nextInt();
			bank.withdraw(acctno, amt);	
			break;
		case 3:
			System.out.println("Enter your account number: ");
			acctno = scan.nextInt();
			bank.checkBalance(acctno);
			break;
		case 4:
			System.out.println("Enter your name: ");
			String name = scan.nextLine();
			bank.createAccount(name);
			break;
		case 5:
			System.out.println("Enter your account number: ");
			acctno = scan.nextInt();
			bank.closeAccount(acctno);
			break;
		case 6:
			System.out.println("Enter your account number: ");
			int fromAcct = scan.nextInt();
			System.out.println("Enter the number of the account you would like to transfer money to: ");
			int toAcct = scan.nextInt();
			System.out.println("How much money would you like to transfer? ");
			amt = scan.nextInt();
			bank.withdraw(fromAcct, amt);
			bank.deposit(toAcct, amt);
			break;
		case 7:
			bank.saveAccounts("Accounts.txt");
			break;
		case 0:
			quit = true;
		} }
		while (!quit);
		
		
	
	
	
	/*
	public static void example1()
	{
		
		Bank bank = new Bank("Bank of CPHS");
		int ewbankAccountNo = bank.createAccount("Mr. Ewbank");
		int howardAccountNo = bank.createAccount("Mr. Howard");
		
		bank.deposit(ewbankAccountNo, 25);
		bank.deposit(howardAccountNo, 75);

		bank.checkBalance(ewbankAccountNo);
		bank.checkBalance(howardAccountNo);
		
		bank.withdraw(ewbankAccountNo, 10);
		bank.closeAccount(howardAccountNo);
		
		bank.checkBalance(ewbankAccountNo);
		bank.checkBalance(howardAccountNo);
		
	}
	*/
	}
}
