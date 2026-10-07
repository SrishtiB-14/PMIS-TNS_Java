package Practice1;

import java.util.Scanner;

public class Divisor {
	
	public static int gcd(int a, int b) {
		while(b != 0) {
			int rem = a % b;
			a = b;
			b = rem;
		}
		return a;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter value for a");
		int a = sc.nextInt();
		
		System.out.println("Enter value for b");
		int b = sc.nextInt();
		
		int res = gcd(a,b);
		
		System.out.println("GCD of "+a+" and "+b+" : "+res);
		
	}

}
