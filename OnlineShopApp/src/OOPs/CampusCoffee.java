package OOPs;

class CoffeeWallet{
	
	String name;
	double bal;
	
	public CoffeeWallet(String name, double bal) {
		this.name = name;
		this.bal = bal;
	}
	
	void addFund(double amt) {
		bal += amt;
		System.out.println("Fund added to your Wallet: "+ amt);
		System.out.println("Balance in your wallet: "+ bal);
	}
	
	void purchase(double amt) {
		if(amt <= bal) {
			bal -= amt;
			System.out.println("Amount deduct from wallet: "+ amt);
			System.out.println("Balance in your wallet: "+ bal);
		}else{
			System.out.println("Insufficient Funds");
		}
	}
	
	void accOverview() {
		System.out.println("Wallet owner: "+ name);
		System.out.println("Current balance: "+ bal);
	}
	
	
}


public class CampusCoffee {
	public static void main(String[] args) {
		
		CoffeeWallet c1 = new CoffeeWallet("Srishti",500);
//		c1.accOverview();
		
		c1.addFund(200);
		
		c1.purchase(800);
		
		
	}

}
