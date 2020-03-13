package com.tyss.assetmanagement1.controllers;

import java.util.Scanner;

import com.tyss.assetmanagement1.beans.Assets;
import com.tyss.assetmanagement1.beans.RequestForm;
import com.tyss.assetmanagement1.beans.UserDetails;
import com.tyss.assetmanagement1.service.Service;
import com.tyss.assetmanagement1.util.exceptions.AssetNotFoundException;

public class ManagerController {

	public static void controller(UserDetails user, Service service, Scanner scanner) {
		System.out.println();
		System.out.println(user);
		do {
			
			try {
			System.out.println("Enter\n1 to see employee details\n2 to display available assets"
					+ "\n3 to raise a new request\n4 to view requests status\n5 to add a new user"
					+ "\n6 to report destroyed assets");

			switch (scanner.nextLine()) {
			case "1":
				for (UserDetails userDetails : service.getUsers()) {
					if (userDetails.getUserType().equalsIgnoreCase("Employee"))
						System.out.println("ID=" + userDetails.getUserID() + " | Name=" 
								+ userDetails.getUserName());
				}

				break;
			case "2":
				for (Assets assets2 : service.getAssets()) {
					System.out.println("\nAssetID: " + assets2.getAssetID() + "Asset Name: " + assets2.getAssetName()
							+ "\nCost per Unit:" + assets2.getAssetCost());
				}
				break;
			case "3":
				for (Assets assets2 : service.getAssets()) {
					System.out.print("\nAssetID: " + assets2.getAssetID() + " | Asset Name: " + assets2.getAssetName()
							+ " | Cost per Unit:" + assets2.getAssetCost());
				}
				System.out.print("\nEnter the Employee's ID: ");
				Integer empID = Integer.parseInt(scanner.nextLine());
				System.out.print("Enter the asset ID: ");
				Integer assetID = Integer.parseInt(scanner.nextLine());
				System.out.print("Enter the quantity: ");
				Integer quantity = Integer.parseInt(scanner.nextLine());
				System.out.print("Enter additional notes --> \n");
				String addNotes = scanner.nextLine();

				Integer check = 0;
				try {
					check = service.addRequest(empID, user.getUserID(), assetID, quantity, addNotes);
				} catch (AssetNotFoundException e) {
					e.printStackTrace();
				}
				System.out.println("manager --> " + check);
				if (check.equals(0))
					System.out.println("Request Made!");
				else if (check.equals(1)) {
					System.out.println("Employee not available in the database");
					System.out.print("Enter 'y' to insert into database: ");
					if (scanner.nextLine().equalsIgnoreCase("y")) {
						System.out.print("Enter the Employee's Name: ");
						String empName = scanner.nextLine();
						System.out.print("Enter the Employee's ID: ");
						String employeeID = scanner.nextLine();
						service.addUser(new UserDetails(empName, "qwerty", "Employee", employeeID));
					}
				} else {
					System.out.println("Requests cannot be made for managers/admin");
				}
				break;
			case "4":
				for (RequestForm requestForm : service.getRequests()) {
					if (requestForm.getManagerID().equals(user.getUserID()))
						System.out.println(requestForm);
				}
				break;
			case "5":
				System.out.println("Enter the Username:");
				String userName = scanner.nextLine();
				System.out.println("Enter the Employee ID");
				String employeeID = scanner.nextLine();
				service.addUser(new UserDetails(userName, "qwerty", "Employee", employeeID));
				break;
			case "6":
				System.out.print("\nEnter the Employee's ID of Owner of the asset: ");
				Integer empID1 = Integer.parseInt(scanner.nextLine());
				System.out.print("Enter the asset ID: ");
				Integer assetID1 = Integer.parseInt(scanner.nextLine());
				System.out.print("Enter the quantity: ");
				Integer quantity1 = Integer.parseInt(scanner.nextLine());
				Integer check1 = 0;
				try {
					check1 = service.addRequest(empID1, user.getUserID(), assetID1, quantity1*-1, 
							"DESTROYED ASSETS - Please allot to remove");
				} catch (AssetNotFoundException e) {
					e.printStackTrace();
				}
				if (check1.equals(0))
					System.out.println("Request Made!");
				else if (check1.equals(1)) {
					System.out.println("Invalid Employee ID!!");
				} else {
					System.out.println("Requests cannot be made for managers/admin");
				}
				
				System.out.println("Feature coming soon");
			default:
				System.out.println("Please enter a valid option");
			}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			
			System.out.print("\nEnter 'y' to continue: ");
		} while (scanner.nextLine().equalsIgnoreCase("y"));

	}

}
