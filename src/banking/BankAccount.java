package banking;

/**
 * Represents a checking/savings bank account for customer.
 * @author fatemabohra
 *
 */
public class BankAccount {
	//instance var
	
	/**
	 * it is a type of account (checking/savings)
	 */
	String accountType;
	
	/**
	 * balance for bank account
	 */
	double balance;
	
	/**
	 * Customer for this account
	 */
	Customer customer;
	
	//constructor
	
	/**
	 * creates a bank account of given type for given customer
	 * @param accountType for given customer
	 * @param customer for given customer
	 */
	public BankAccount(String accountType, Customer customer) {
		this.accountType = accountType;
		this.customer = customer;
	}
	
	//methods
	
	/**
	 * deposits the given amount
	 * @param amount to add to balance
	 */
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	/**
	 * Withdraws the given amount from balance
	 * @param amount to withdraw
	 * @throws Exception if given balance greater than withdraw
	 */
	public void withdraw(double amount) throws Exception {
		if (amount > this.balance) {
			throw new Exception("Amount is greater than the given balance");
		}
		this.balance -= amount;
	}
	
	/**
	 * returns account type and balance for this bank account.
	 * @return
	 */
	public String getAccountInfo() {
		return this.accountType + ": " + this.balance;
	}
	
	/**
	 * returns customer's accountType.
	 * @return String with all the info.
	 */
	public String getaccountType() {
		return this.accountType;
	}
	
	/**
	 * returns the customer name and address for this bank account
	 * @return string with all the info
	 */
	public String getCustomerInfo(){
		return this.customer.getName() + " from " + this.customer.getAddress();
    }
}	
	