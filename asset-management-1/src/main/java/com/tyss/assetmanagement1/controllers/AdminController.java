package com.tyss.assetmanagement1.controllers;

import java.util.Scanner;

import com.tyss.assetmanagement1.beans.Assets;
import com.tyss.assetmanagement1.beans.RequestForm;
import com.tyss.assetmanagement1.beans.UserDetails;
import com.tyss.assetmanagement1.service.Service;
import com.tyss.assetmanagement1.util.exceptions.AssetNotFoundException;
import com.tyss.assetmanagement1.util.exceptions.QuantityNotAvailableException;
import com.tyss.assetmanagement1.util.exceptions.RequestNotFoundException;

public class AdminController {

	public static void controller(UserDetails user, Service service, Scanner scanner) {

		System.out.println();
		System.out.println(user);
			do {
			try {
			System.out.println(
					"Enter\n1 to display all assets\n2 to view pending requests\n3 to view an asset's details completely"
							+ "\n4 to create a new user\n5 to add/update an asset\n6 to view approved requests");

			switch (scanner.nextLine()) {
			case "1":
				for (Assets assets2 : service.getAssets()) {
					System.out.println("\n" + assets2.getAssetID() + " - " + assets2.getAssetName() 
					+ ", Cost per Unit:" + assets2.getAssetCost() + ", Alloted Units:" + assets2.getAllotedM());
				}
				break;
			case "2":
				for (RequestForm requestForm : service.getRequests()) {
					if (!requestForm.isAlloted())
						System.out.println(requestForm);
				}
				System.out.print("Enter the Form ID to allocate : ");
				try {
					if (service.allot(Integer.parseInt(scanner.nextLine())))
						System.out.println("Asset alloted successfully!");
					else
						System.out.println("Already alloted");
				} catch (NumberFormatException | QuantityNotAvailableException e) {
					System.out.println(e.getMessage());
				} catch (RequestNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			case "3":
				System.out.print("Enter the asset ID: ");
				Assets asset = service.getAsset(Integer.parseInt(scanner.nextLine()));
				System.out.println("\n" + asset.getAssetID() + " - " + asset.getAssetName() 
				+ ", Cost per Unit:" + asset.getAssetCost() + ", TotalUnits: " + asset.getAssetQuantity()
				+ ", Alloted Units: " + asset.getAllotedM());
				System.out.println("Manager ID : Alloted Quantity");
				System.out.println(asset.getManagers());
				System.out.println(asset.getEmployees());
				break;
			case "4":
				System.out.println("Enter the Username:");
				String userName = scanner.nextLine();
				System.out.println("Enter the Employee ID");
				String employeeID = scanner.nextLine();
				service.addUser(new UserDetails(userName, "qwerty", "Manager", employeeID));
				break;
			case "5":
				System.out.print("Enter asset ID to update(0 to add new asset): ");
				Integer assetID = Integer.parseInt(scanner.nextLine());
				if (assetID == 0) {
					System.out.print("Enter Asset's Name: ");
					String assetName = scanner.nextLine();
					System.out.print("Enter Cost per Unit: ");
					Double price = Double.parseDouble(scanner.nextLine());
					System.out.print("Enter Number of available units: ");
					Integer quantity = Integer.parseInt(scanner.nextLine());
					service.addAsset(new Assets(assetName, quantity, price));
					System.out.println("Asset Added!");
				} else {
					System.out.print("Enter the quantity to be added: ");
					try {
						service.updateAsset(assetID, Integer.parseInt(scanner.nextLine()));
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (AssetNotFoundException e) {
						e.printStackTrace();
					}
				}
			case "6":
				for (RequestForm requestForm : service.getRequests()) {
					if (requestForm.isAlloted())
						System.out.println(requestForm);
				}
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
