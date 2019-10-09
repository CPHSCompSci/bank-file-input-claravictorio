package app;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		example1();
		
		Bank bank = new Bank("Knab Bank");
		Scanner scan = new Scanner(System.in);
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("3. Check balance");
		System.out.println("4. Create account");
		System.out.println("5. Close Account");
		System.out.println("6. Transfer funds");
		System.out.println("Select an option: ");
		int selection = scan.nextInt();
		
		if (selection == 1)
		{
			
		}
		else if (selection == 2)
		{
			
		}
		else if (selection == 3)
		{
			
		}
		else if (selection == 4)
		{
			
		}
		else if (selection == 5)
		{
			
		}
		else if (selection == 6)
		{
			
		}
		
	}
	
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
}
