package basics;

import java.util.Scanner;

public class Calculation {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a number");
//		
//		float n1 = sc.nextFloat();
//		System.out.println("Enter a number");
//		float n2 = sc.nextFloat();
//		
//		
//		System.out.println(n1 + n2);
		
		
		///Conversion of Fah to Cel
//		float cel = (n1 +32)*5/9;
//		
//		System.out.println(n1 + " in Celcius "+cel);
		
		
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1: System.out.println("January"); break;
		case 2: System.out.println("February"); break;
		case 3: System.out.println("March");break;
		case 4: System.out.println("April"); break;
		case 5: System.out.println("May"); break;
		case 6: System.out.println("June"); break;
		case 7: System.out.println("July"); break;
		case 8: System.out.println("August"); break;
		case 9: System.out.println("September"); break;
		case 10: System.out.println("October"); break;
		case 11: System.out.println("november"); break;
		case 12: System.out.println("December"); break;
		default: System.out.println("Invalid Number");
		}
		
		
		
	}

}
