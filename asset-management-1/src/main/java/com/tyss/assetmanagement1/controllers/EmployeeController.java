package com.tyss.assetmanagement1.controllers;

import java.util.List;
import java.util.Scanner;

import com.tyss.assetmanagement1.beans.Assets;
import com.tyss.assetmanagement1.beans.UserDetails;

public class EmployeeController {

	public static void controller(UserDetails user, List<Assets> assets, Scanner scanner) {

		System.out.println();
		System.out.println(user);
		for (Assets assets2 : assets) {
			if (assets2.getEmployeeNos(user.getUserID()) != 0)
				System.out.println("\n" + assets2.getAssetName() + "-  Alloted Units:"
						+ assets2.getEmployeeNos(user.getUserID()) + ", Cost per Unit:"
						+ assets2.getAssetCost());
		}
		/*do {
			System.out.println(
					"Enter\n1 to display alloted assets details\n2 to view requests\n3 to view an asset's details completely");
			
			switch (scanner.nextLine()) {
			case "1":
				for (Assets assets2 : assets) {
					if (assets2.getEmployeeNos(user.getUserID()) != 0)
						System.out.println("\n" + assets2.getAssetName() + "-  Alloted Units:"
								+ assets2.getEmployeeNos(user.getUserID()) + ", Cost per Unit:"
								+ assets2.getAssetCost());
				}
				break;
			case "2":
			case "3":
				System.out.println("Feature Coming soon");
				break;
			default:
				System.out.println("Please enter a valid option");
			}
			System.out.print("\nEnter 'y' to continue: ");
		} while (scanner.nextLine().equalsIgnoreCase("y"));
		 */
	}
}
