package OOPs;


class Account{

	
	String accHolder;
	 int totalBal;
	 
	 
	
	public Account(String accHolder, int totalBal) {
		super();
		this.accHolder = accHolder;
		this.totalBal = totalBal;
	}

	void deposit(int amt) {
	
		totalBal += amt;
		
		System.out.println("Amount deposited: "+ amt);
		System.out.println("Current Balance: "+ totalBal);
	}
	
	void withdraw(int amt1) {
		if(amt1 <= totalBal) {
		totalBal -= amt1;
		System.out.println("Amount withdrawn: "+ amt1);
		System.out.println("Current Balance: "+ totalBal);
		}else {
			System.out.println("Insufficient Balance");
		}
	}
	
	void checkBal() {
		 
		System.out.println("Total Balance: "+ totalBal);
		
	}
	
	void displayAccHolder() {
		System.out.println("Account Holder: "+ accHolder);
		System.out.println("Total balance: "+ totalBal);
	}
	
	
	
}

public class Bank {
	public static void main(String[] args) {
		
		Account a1 = new Account("Srishti",10000);
		a1.deposit(2000);
		System.out.println("--------------------");
		a1.withdraw(15000);
		System.out.println("--------------------");
		a1.displayAccHolder();
	}

}
