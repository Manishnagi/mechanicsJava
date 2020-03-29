package com.tyss.assetmanagement1.controllers;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.tyss.assetmanagement1.beans.Assets;
import com.tyss.assetmanagement1.beans.RequestForm;
import com.tyss.assetmanagement1.beans.UserDetails;
import com.tyss.assetmanagement1.service.Service;
import com.tyss.assetmanagement1.util.PasswordEncoder;
import com.tyss.assetmanagement1.util.exceptions.AssetNotFoundException;
import com.tyss.assetmanagement1.util.exceptions.InvalidPasswordException;
import com.tyss.assetmanagement1.util.exceptions.InvalidUsernameException;
import com.tyss.assetmanagement1.util.exceptions.QuantityNotAvailableException;
import com.tyss.assetmanagement1.util.exceptions.RequestNotFoundException;

/**
 * Controller with dedicated functionalities for an ADMIN 
 * 
 * @author C J Rohan
 *
 */
public class AdminController {

	private AdminController() {

	}

	public static void controller(UserDetails user, Service service, Scanner scanner) {

		boolean loggedIn = true;
		Logger logger = Logger.getLogger(MainController.class);
		do {
			try {
				Thread.sleep(500);
				logger.info("\n" + user.toString() );
				logger.info(
						"\nEnter\n1 to display all assets\n2 to view pending requests\n3 to view an asset's details completely"
								+ "\n4 to create a new user\n5 to add/update an asset\n6 to view approved requests"
								+ "\n7 to change password\nL to LOGOUT");

				switch (scanner.nextLine()) {
				case "1":
					logger.info("\nID");
					for (Assets assets2 : service.getAssets()) {
						logger.info("\n" + assets2.getAssetID() + " - " + assets2.getAssetName()
								+ ", Cost per Unit:" + assets2.getAssetCost() + ", Total Units:"
								+ assets2.getAssetQuantity() + ", Alloted:" + assets2.getAllotedM() + ", Available:"
								+ (assets2.getAssetQuantity() - assets2.getAllotedM()));
					}
					break;
				case "2":
					logger.info("\nID\n");
					for (RequestForm requestForm : service.getRequests()) {
						if (!requestForm.isAlloted())
							logger.info("\n" + requestForm );
					}
					logger.info("\nEnter the Form ID to allocate : ");
					try {
						if (service.allot(Integer.parseInt(scanner.nextLine())))
							logger.info("\nAsset alloted successfully!");
						else
							logger.info("\nAlready alloted");
					} catch (QuantityNotAvailableException | RequestNotFoundException | AssetNotFoundException e) {
						e.printStackTrace();
					}
					break;
				case "3":
					logger.info("\nEnter the asset ID: ");
					Assets asset = service.getAsset(Integer.parseInt(scanner.nextLine()));
					logger.info("\n" + asset.getAssetID() + " - " + asset.getAssetName() + ", Cost per Unit:"
							+ asset.getAssetCost() + ", TotalUnits: " + asset.getAssetQuantity() + ", Alloted Units: "
							+ asset.getAllotedM());
					logger.info("\n{Manager ID=Alloted Quantity, ...}");
					logger.info("\n" + asset.getManagers()  );
					break;
				case "4":
					while (true) {
						try {
							logger.info("\nEnter the Name:");
							String userName = scanner.nextLine();
							logger.info("\nEnter the Employee ID");
							String employeeID = scanner.nextLine();
							service.addUser(new UserDetails(userName, "qwerty", "Manager", employeeID));
							break;
						} catch (InvalidUsernameException e) {
							logger.info("\n" + e.getMessage() );
						}
					}
					break;
				case "5":
					logger.info("\nEnter asset ID to update(0 to add new asset): ");
					Integer assetID = Integer.parseInt(scanner.nextLine());
					if (assetID == 0) {
						logger.info("\nEnter Asset's Name: ");
						String assetName = scanner.nextLine();
						logger.info("\nEnter Cost per Unit: ");
						Double price = Double.parseDouble(scanner.nextLine());
						logger.info("\nEnter Number of available units: ");
						Integer quantity = Integer.parseInt(scanner.nextLine());
						service.addAsset(new Assets(assetName, quantity, price));
						logger.info("\nAsset Added!");
					} else {
						logger.info("\nEnter the quantity to be added: ");
						try {
							service.updateAsset(assetID, Integer.parseInt(scanner.nextLine()));
							logger.info("\nAsset updated Successfully!\n");
						} catch (NumberFormatException e) {
							e.printStackTrace();
						} catch (AssetNotFoundException e) {
							e.printStackTrace();
						}
					}
					break;
				case "6":
					logger.info("\nID\n");
					for (RequestForm requestForm : service.getRequests()) {
						if (requestForm.isAlloted())
							logger.info("\n" + requestForm );
					}
					break;
				case "7":
					while (true) {
						try {
							logger.info("\nEnter your password again: ");
							String password = scanner.nextLine();
							if (PasswordEncoder.checkPassword(password, user.getPassword())) {
								logger.info("\nEnter your new password: ");
								password = scanner.nextLine();
								service.changePassword(user.getUserID(), password);
							} else {
								logger.info("\n--Please try again with the correct password--");
							}
							break;
						} catch (InvalidPasswordException e) {
							logger.info("\n" + e.getMessage() );
						}
					}
					break;
				case "L":
				case "l":
					logger.info("\nLogging Out..");
					loggedIn = false;
					break;
				default:
					logger.info("\nPlease enter a valid option");
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		} while (loggedIn);

	}

}
