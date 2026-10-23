package Practice1;

import java.util.Scanner;

public class Power {
	
	public static double pow(int x, int n) {
		return Math.pow(x, n);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter value for x");
		int x = sc.nextInt();
		
		System.out.println("Enter value for n");
		int n = sc.nextInt();
		
		double res = pow(x,n);
		System.out.println(x+" raise to the power of "+n+" is "+res);
		
		
		
	}

}
