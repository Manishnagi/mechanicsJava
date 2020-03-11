package com.tyss.assetmanagement1.controllers;

import java.util.Scanner;

import com.tyss.assetmanagement1.beans.Assets;
import com.tyss.assetmanagement1.beans.RequestForm;
import com.tyss.assetmanagement1.beans.UserDetails;
import com.tyss.assetmanagement1.service.Service;

public class ManagerController {

	public static void controller(UserDetails user, Service service, Scanner scanner) 
	{
		System.out.println();
		System.out.println(user);
		do {
			System.out.println(
					"Enter\n1 to display available assets\n2 to display alloted assets details\n3 to raise a new request\n4 to view requests status");
			
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
				for (Assets assets2 : service.getAssets()) {
					if (assets2.getEmployeeNos(user.getUserID()) != 0)
						System.out.println("\n" + assets2.getAssetName() + "-  Alloted Units:"
								+ assets2.getManagerNos(user.getUserID()) + ", Cost per Unit:"
								+ assets2.getAssetCost());
				}
				break;
			case "3": 
				System.out.print("Enter the Employee's ID: ");
				Integer empID = Integer.parseInt(scanner.nextLine());
				System.out.print("Enter the Asset's ID: ");
				Integer assetID = Integer.parseInt(scanner.nextLine());
				System.out.print("Enter the quantity: ");
				Integer quantity = Integer.parseInt(scanner.nextLine());
				System.out.print("Enter additional notes --> \n");
				String addNotes = scanner.nextLine();
				
				service.addRequest(new RequestForm(empID, assetID, quantity, addNotes));
				
				
				break;
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
