package app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CashRegister {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
////		
////	USER STORY #1 
////		
		System.out.println("Hello, please enter cost of item?: ");
		double costOfItem = sc.nextDouble();
		
////		
////	USER STORY #2
////		
		System.out.println("Please enter amount paid: ");
		double amtPaid;
		try {
			amtPaid = sc.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("invalid input please try again");
			sc.nextLine();
			amtPaid = sc.nextDouble();
		}
		
////		
////	USER STORY #4
////		
		if(amtPaid > costOfItem) {
			double amtChangeOwed = .001 + amtPaid - costOfItem;
			
			System.out.print("Give the customer: ");
			
//			twenty dollar bills
			int twenties = (int) amtChangeOwed / 20;
			double tw = 20 * twenties;
			
			if (twenties == 1) {
				System.out.print(twenties + " twenty, ");	
			}
			else if (twenties > 1) {
				System.out.print(twenties + " twenties, ");	
			}
			amtChangeOwed = amtChangeOwed - tw; //subtracting how many 20s from the total change and reassigning the variable to that.
		
			
//			10 dollar bills
			int tens = (int) amtChangeOwed / 10;
			double t = 10 * tens;
			
			if (tens == 1) {
				System.out.print(tens + " ten, ");	
			}
			else if (tens > 1) {
				System.out.print(tens + " tens, ");	
			}
			amtChangeOwed = amtChangeOwed - t; //subtracting how many 10s from the total change and reassigning the variable to that.

			
//			5 dollar bills
			int fives = (int) amtChangeOwed / 5;
			double fiv = 5 * fives;
			
			if (fives == 1) {
				System.out.print(fives + " five, ");	
			}
			else if (fives > 1) {
				System.out.print(fives + " fives, ");	
			}
			amtChangeOwed = amtChangeOwed - fiv; //subtracting how many 5s from the total change and reassigning the variable to that.

//			one dollar bills
			int dollars = (int) amtChangeOwed / 1;
			double d = 1 * dollars;
			
			if (dollars == 1) {
				System.out.print(dollars + " dollar, ");	
			}
			else if (dollars > 1) {
				System.out.print(dollars + " dollars, ");	
			}
			amtChangeOwed = amtChangeOwed - d; //subtracting how many 1s from the total change and reassigning the variable to that.
			
//			Quarters
			int amtChangeOwedCoin = ((int)(amtChangeOwed * 100));
			
			int quarters = (amtChangeOwedCoin) / 25;
			int q = 25 * quarters;
			
			if (quarters == 1) {
				System.out.print(quarters + " quarter, ");	
			}
			else if (quarters > 1) {
				System.out.print(quarters + " quarters, ");	
			}
			amtChangeOwedCoin = amtChangeOwedCoin - q; //subtracting how many quarters from the total change and reassigning the variable to that.

			
			int dimes = (amtChangeOwedCoin) / 10;
			int dim = 10 * dimes;
			
			if (dimes == 1) {
				System.out.print(dimes + " dime, ");	
			}
			else if (dimes > 1) {
				System.out.print(dimes + " dimes, ");	
			}
			amtChangeOwedCoin = amtChangeOwedCoin - dim; //subtracting how many dimes from the total change and reassigning the variable to that.

			
			int nickles = amtChangeOwedCoin / 5;
			int nick = 5 * dimes;
			
			if (nickles == 1) {
				System.out.print(nickles + " nickle, ");	
			}
			else if (nickles > 1) {
				System.out.print(nickles + " nickles, ");	
			}
			amtChangeOwedCoin = amtChangeOwedCoin - nick; //subtracting how many nickles from the total change and reassigning the variable to that.

			
			int pennies = amtChangeOwedCoin / 1;
			int p = pennies;
			
			if (pennies == 1) {
				System.out.print(pennies + " penny. ");	
			}
			else if (pennies > 0) {
				System.out.print(p + " pennies. ");	
			}
			
		}
		
////		
////		USER STORY #3
////		
		else if( amtPaid < costOfItem ) {
			double amtOwed = costOfItem - amtPaid;
			
			
			System.out.printf("You still owe $%.2f\n" , amtOwed);
		}
		else {
			System.out.println("Thank you, come again!");
		}
			
		sc.close();
	} //this is main method curly braces

}
