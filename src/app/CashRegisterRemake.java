package app;

import java.util.Scanner;

public class CashRegisterRemake {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		double itemPrice = 0.0, amtPaid = 0.0, moneyDifference = 0.0;
		boolean keepGoing = true, keepGoing2 = true;

		// USER STORY 1
		// *************************************************************************************************
		while (keepGoing) { // loops the question until the user enters a correct data type.
			System.out.println("How much did the item cost?");
			try {
				itemPrice = sc.nextDouble();
				keepGoing = false;

			} catch (Exception e) {
				System.out.println("***ERROR***PLEASE ENTER A VALID NUMBER (EX. 12.99, 4,) ");
				sc.nextLine(); // used to clear the buffer
			}
		}

		// USER STORY 2
		// *************************************************************************************************
		while (keepGoing2) {
			System.out.println("Enter amount customer paid: ");
			try {
				amtPaid = sc.nextDouble();
				keepGoing2 = false;
			} catch (Exception e) {
				System.out.println("***ERROR***PLEASE ENTER A VALID NUMBER (EX. 12.99, 4,) ");
				sc.nextLine();
			}
		}

		// USER STORY 3
		// *************************************************************************************************
		if (amtPaid == itemPrice) {
			System.out.println("Have a nice day! Come again :)");
			System.exit(0);
			sc.close();
		} else {
			if (amtPaid < itemPrice) {
				moneyDifference = itemPrice - amtPaid;
				System.out.printf("You still owe $%.2f\n", moneyDifference);
			} else {
				// USER STORY 4
				// *************************************************************************************************
				moneyDifference = amtPaid - itemPrice;
				System.out.printf("You paid to much! We owe you $%.2f\n", moneyDifference);
				String change = "Your change is: ";
				int moneyDifferenceBills = (int) moneyDifference;
				int moneyDifferenceCoins = (int) (100 * ((moneyDifference - moneyDifferenceBills) + .001));
				int amount = 0;

				// BILLS
				if (moneyDifferenceBills >= 20) { // Check to see if it needs to do give twenties
					amount = moneyDifferenceBills / 20; // how many 20s go into change
					change = change + "\n 20 dollar bills x " + amount;
					moneyDifferenceBills = moneyDifferenceBills - (amount * 20); // reassigns new value w/ out 20
				}
				if (moneyDifferenceBills >= 10) {
					amount = moneyDifferenceBills / 10;
					change = change + "\n 10 dollar bills x " + amount;
					moneyDifferenceBills = moneyDifferenceBills - (amount * 10);
				}
				if (moneyDifferenceBills >= 5) {
					amount = moneyDifferenceBills / 5;
					change = change + "\n 5 dollar bills x " + amount;
					moneyDifferenceBills = moneyDifferenceBills - (amount * 5);
				}
				if (moneyDifferenceBills >= 1) {
					amount = moneyDifferenceBills / 1;
					change = change + "\n 1 dollar bills x " + amount;
					moneyDifferenceBills = moneyDifferenceBills - amount;
				}
				// COINS
				if (moneyDifferenceCoins >= 25) {
					amount = moneyDifferenceCoins / 25;
					change = change + "\n Quarters x " + amount;
					moneyDifferenceCoins = moneyDifferenceCoins - amount * 25;
				}
				if (moneyDifferenceCoins >= 10) {
					amount = moneyDifferenceCoins / 10;
					change = change + "\n Dimes x " + amount;
					moneyDifferenceCoins = moneyDifferenceCoins - amount * 10;
				}
				if (moneyDifferenceCoins >= 5) {
					amount = moneyDifferenceCoins / 5;
					change = change + "\n Nickles x " + amount;
					moneyDifferenceCoins = moneyDifferenceCoins - amount * 5;
				}
				if (moneyDifferenceCoins >= 1) {
					amount = moneyDifferenceCoins;
					change = change + "\n Pennies x " + amount;
					moneyDifferenceCoins = moneyDifferenceCoins - amount;
				}
				System.out.println(change);
			}
		}
		sc.close();
	}
}