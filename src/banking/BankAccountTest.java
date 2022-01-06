package banking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountTest {
	
    //declare objects for testing
	Customer customer;
	BankAccount myCheckingAccount;
	BankAccount mySavingAccount;
	
	@BeforeEach
	void setUp() throws Exception {
		
		//initialize objects here for testing
		this.customer = new Customer("Brandon");
		this.myCheckingAccount = new BankAccount("checking", this.customer);
		this.mySavingAccount = new BankAccount("saving", this.customer);
		
	}

	@Test
	void testDeposit() {
		//make deposits
		this.myCheckingAccount.deposit(100);
		
		//test that current balance is 100.
		assertEquals(100, this.myCheckingAccount.balance);
		
		//make deposit of negative amount
		this.myCheckingAccount.deposit(-100);
		
		//balance should be the same
		assertEquals(100, this.myCheckingAccount.balance);
		
		//deposit 0
		this.myCheckingAccount.deposit(0);
		
		//balance should be the same
		assertEquals(100, this.myCheckingAccount.balance);
	}

	@Test
	void testWithdraw() {
		//deposit initial 100 into saving...to withdraw something we need to deposit first.
		this.mySavingAccount.deposit(100);
		
		//assert current balance
		assertEquals(100, this.mySavingAccount.balance);
		
		//try to make withdraw of 80
		try {
			this.mySavingAccount.withdraw(80);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//balance should be 20
		assertEquals(20, this.mySavingAccount.balance);
		
		//try to withdraw mount greater than balance
		//expect an exception
		assertThrows(Exception.class, () ->{
		   this.mySavingAccount.withdraw(21);
		});   
		
		//balance should be same
		assertEquals(20, this.mySavingAccount.balance);
		
		//try to make withdraw
		//does not throw exception
		assertDoesNotThrow(() -> {
			this.mySavingAccount.withdraw(19);
		});
		
		//remaining dollar should be 1
		assertEquals(1, this.mySavingAccount.balance);
	}

	@Test
	void testFastWithdraw() {
		//initial deposit
		this.myCheckingAccount.deposit(100);
		
		//Try to make fast withdraw
		//default amount is 60
		try {
			this.myCheckingAccount.fastWithdraw();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//balance should be 40
		assertEquals(40, this.myCheckingAccount.balance);
		
		//reset the fast cash amount to 20
		this.myCheckingAccount.setFastCashAmount(20);
		
		//assert that an exception is not thrown when I make fast withdrawal
		assertDoesNotThrow(() -> {
			this.myCheckingAccount.fastWithdraw();
		});
		
		//checks balance 
		assertEquals(20, this.myCheckingAccount.balance);
		
		//set fast cash amount to negative value
		//should e ignored
		this.myCheckingAccount.setFastCashAmount(-50);
		
		//should still withdraw 20
		try {
			this.myCheckingAccount.fastWithdraw();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//balance should e 0 after withdraw
		assertEquals(0, this.myCheckingAccount.balance);
		
		//expecting exception when I try to make fast withdrawal because of balance 0
		assertThrows(Exception.class, () -> {
			this.myCheckingAccount.fastWithdraw();
		});
	}

}
