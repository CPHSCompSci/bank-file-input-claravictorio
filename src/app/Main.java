package app;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		
		Bank bank = new Bank("The Bank");
		Scanner scan = new Scanner(System.in);
		int selection;
		boolean quit = false;
		bank.loadAccounts("Accounts.txt");
		
		do {
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Check balance");
			System.out.println("4. Create account");
			System.out.println("5. Close account");
			System.out.println("6. Transfer funds");
			System.out.println("0. Quit and Save Accounts");
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
			bank.deposit(acctno, amt, false);
			break;
		case 2:
			System.out.println("Enter your account number: ");
			acctno = scan.nextInt();
			System.out.println("How much would you like to withdraw?");
			amt = scan.nextInt();
			bank.withdraw(acctno, amt, false);	
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
			if (bank.withdraw(fromAcct, amt, true) && bank.deposit(toAcct, amt, true))
			{
				bank.withdraw(fromAcct, amt, false);
				bank.deposit(toAcct, amt, false); // need to check if both possible first
			}
			break;
		case 0:
			bank.saveAccounts("Accounts.txt");
			quit = true;
			break;
		} }
		while (!quit);
		
	}
}
