package com.tyss.assetmanagement1.controllers;

import java.util.Scanner;

import com.tyss.assetmanagement1.beans.Assets;
import com.tyss.assetmanagement1.beans.RequestForm;
import com.tyss.assetmanagement1.beans.UserDetails;
import com.tyss.assetmanagement1.service.Service;

public class AdminController {

	public static void controller(UserDetails user, Service service, Scanner scanner) {
//		Scanner scanner = new Scanner(System.in)

		System.out.println();
		System.out.println(user);
		do {
			System.out.println(
					"Enter\n1 to display all assets\n2 to view requests\n3 to view an asset's details completely\n4 to create a new user");

			switch (scanner.nextLine()) {
			case "1":
				for (Assets assets2 : service.getAssets()) {
					System.out.println("\n" + assets2.getAssetName() + " - Available Units:"
							+ assets2.getAssetQuantity() + ", Cost per Unit:" + assets2.getAssetCost() + "(Total="
							+ assets2.getAssetQuantity() * assets2.getAssetCost() + ")" + ", Alloted Units:"
							+ assets2.getAllotedM());
				}
				break;
			case "2": 
				for (RequestForm requestForm : service.getRequests()) {
					System.out.println(requestForm);
				}
				break;
			case "3":
			case "4":
				System.out.println("Feature Coming soon");
				break;
			default:
				System.out.println("Please enter a valid option");
			}

			System.out.print("\nEnter 'y' to continue: ");
		} while (scanner.nextLine().equalsIgnoreCase("y"));

	}

}
