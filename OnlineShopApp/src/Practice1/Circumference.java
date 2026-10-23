package Practice1;

import java.util.Scanner;

public class Circumference {
	
	public static double circum(double r) {
		return 2*3.14*r;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter radius");
		
		double r = sc.nextDouble();
		
		double res = circum(r);
		System.out.println("Circumference of "+ r+" is "+res);
		
	}

}
