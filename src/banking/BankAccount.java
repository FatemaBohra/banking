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
	
	/**
	 * Fixed amount for quick withdrawals.
	 */
	double fastCashAmount;
	
	//constructor
	
	/**
	 * creates a bank account of given type for given customer
	 * @param accountType for given customer
	 * @param customer for given customer
	 */
	public BankAccount(String accountType, Customer customer) {
		this.accountType = accountType;
		this.customer = customer;
		
		//set initial default value for fast cash amount.
		this.fastCashAmount = 60;
	}
	
	//methods
	
	/**
	 * deposits the given amount, if greater than 0
	 * @param amount to add to balance
	 */
	public void deposit(double amount) {
		if (amount > 0) {
		   this.balance += amount;
		}   
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
	 * withdraws the fast cash amount
	 * @throws Exception if given fast cash amount is greater than balance
	 */
	public void fastWithdraw() throws Exception {
		//withdraw the given fast cash amount.
		this.withdraw(this.fastCashAmount);
	}
	
	/**
	 * sets the fast cash amount, if greater than 0
	 * @param amount to set as fast cash
	 */
	public void setFastCashAmount(double amount) {
		if(amount > 0) {
			this.fastCashAmount = amount;
		}
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
	