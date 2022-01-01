package banking;

import java.util.Scanner;

/**
 * Represents a bank for managing customers and their bank account.
 * @author fatemabohra
 *
 */

public class Bank {

	public static void main(String[] args) {
		// creates new instance of bank class
		Bank bank = new Bank();
		
		// calls the run method in the bank class
		bank.run();

	}
	
	/*
	 * Runs the program by initializing and managing, bank accounts and customer.
	 */
	
	public void run() {
		System.out.println("Welcome to the bank. What is your name? ");
		//create scanner to get user input
		Scanner scanner = new Scanner(System.in);
		
		//get the next token (word), which is the customer's name.
		String name = scanner.next();
		
		System.out.println("Hello " + name + "! We are creating checking and saving accounts for you.");
		
		//create customer with given name
		Customer customer = new Customer(name);
		
		//get address
		System.out.println("What is your address?");
		
		// get the next token (word), which is customer's address.
		String address = scanner.next();
		
		//sets the customer's address
		customer.setAddress(address);
		
		//create a checking account for customer
		BankAccount checkingAccount = new BankAccount("Checking", customer);
		
		//create a saving account for customer
		BankAccount savingAccount = new BankAccount("Saving", customer);
		
		//gets and print the customer's info associated with checking account
		System.out.println();
		System.out.println("Customer info: ");
		System.out.println(checkingAccount.getCustomerInfo());
		
		//gets and print the account info associated with checking account
		System.out.println("Checking account: ");
		System.out.println(checkingAccount.getAccountInfo());
		System.out.println("Saving account: ");
		System.out.println(savingAccount.getAccountInfo());
		
		//deposits
		
		//into checking
		System.out.println();
		System.out.println("Amount (decimal) to deposit into your checking account?");
		double amount = scanner.nextDouble();//gets next token (double)
		checkingAccount.deposit(amount); //deposit into checking account
		
		//into saving
		System.out.println();
		System.out.println("Amount (decimal) to deposit into your saving account?");
		amount = scanner.nextDouble();//gets next token (double)// In java you need to declare variable once.
	    savingAccount.deposit(amount); //deposit into saving account
	    
	    //prints new balances
	    System.out.println(checkingAccount.getAccountInfo());
	    System.out.println(savingAccount.getAccountInfo());
	    
	    //withdrawals
	    
	    //from checking
	    System.out.println();
	    System.out.println("Amount (decimal) to withdraw from your checking account?");
	    amount = scanner.nextDouble();// gets the next token as double
	    
	    try {
			checkingAccount.withdraw(amount);//withdraws from checking
		} catch (Exception e) {
			//e.printStackTrace();
			
			System.out.println(e.getMessage());//prints custom message from withdraw method
		}
	    
	    //from savings
	    System.out.println();
	    System.out.println("Amount (decimal) to withdraw from your saving account?");
	    amount = scanner.nextDouble();// gets the next token as double
	    
	    try {
			savingAccount.withdraw(amount);//withdraws from saving
		} catch (Exception e) {
			//e.printStackTrace();
			
			System.out.println(e.getMessage());//prints custom message from withdraw method
		}
	    
	    //prints new balances
	    System.out.println(checkingAccount.getAccountInfo());
	    System.out.println(savingAccount.getAccountInfo());
	    
	    scanner.close();
	}

}
