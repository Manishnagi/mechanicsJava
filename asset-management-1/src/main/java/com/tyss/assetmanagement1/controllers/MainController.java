package com.tyss.assetmanagement1.controllers;

import java.util.Scanner;

import com.tyss.assetmanagement1.beans.UserDetails;
import com.tyss.assetmanagement1.service.Service;
import com.tyss.assetmanagement1.util.factory.Factory;

public class MainController {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Service service = Factory.getService();
		
		do {
			try {
				// To get user name and password for login
				System.out.println("Enter your login details");
				System.out.print("Enter your User Name: ");
				String userName = scanner.nextLine();
				System.out.print("Enter your password: ");
				String password = scanner.nextLine();

				// searching for the user
				UserDetails user = service.getUser(userName, password);

				// logging in with respective controller...
				if (user != null) {
					switch (user.getUserType()) {
					case "Admin":
						AdminController.controller(user, service, scanner);
						break;
					case "Manager":
						ManagerController.controller(user, service, scanner);
						break;
					case "Employee":
//						EmployeeController.controller(user, service, scanner);
						System.out.println("Employee cannot login");
						break;
					default:
						System.out.println("This will be avoided always...");
					}
				} else {
					System.out.println("Enter a valid username and correct password");
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			System.out.print("\n\nLogging out...\nEnter 'y' to login again: ");

		} while (scanner.nextLine().equalsIgnoreCase("y"));

		scanner.close();
	}

}
