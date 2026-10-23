package Practice1;

import java.util.Scanner;

public class Average {
	
	
	public static double average(double a, double b, double c) {
		
		return (a+b+c)/3;
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter 1st Number");
		
		double n1 = sc.nextDouble();
		
		System.out.println("Enter 2nd Number");
		
		double n2 = sc.nextDouble();
		
		System.out.println("Enter 3rd Number");
		
		double n3 = sc.nextDouble();
		
		double result = average(n1,n2,n3);
		
		System.out.println("Average : "+ result);
		
		
		
	}

}
