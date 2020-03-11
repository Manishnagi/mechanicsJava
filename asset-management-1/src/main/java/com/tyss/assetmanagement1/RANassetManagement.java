package com.tyss.assetmanagement1;

import java.util.Scanner;

public class RANassetManagement {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welecome to RAN Asset Management\n1 for Login\n2 for Sign up");
		System.out.print("Enter your choice: ");
		String choice;
		choice = scanner.nextLine();
		switch (choice) {
		case "1": // Login.login();
			System.out.println("Login!");
			break;
		case "2": // SignUp.signUp();
			System.out.println("SignUp");
			break;
		default : System.out.println("Invalid Option(Enter '1' or '2')");
		}
		scanner.close();
	}
}
