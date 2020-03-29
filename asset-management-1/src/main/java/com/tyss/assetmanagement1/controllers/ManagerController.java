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

/**
 * Controller with dedicated functionalities for a User(Manager)
 * 
 * @author C J Rohan
 *
 */
public class ManagerController {

	private ManagerController() {

	}

	public static void controller(UserDetails user, Service service, Scanner scanner) {
		boolean loggedIn = true;
		Logger logger = Logger.getLogger(MainController.class);
		do {
			try {
				Thread.sleep(500);
				logger.info("\n" + user.toString() );
				logger.info("\nEnter\n1 to see employee details\n2 to display available assets"
						+ "\n3 to raise a new request\n4 to view requests status\n5 to add a new employee to database"
						+ "\n6 to report destroyed assets\n7 to change password\nL to logout");

				switch (scanner.nextLine().strip()) {
				case "1":
					logger.info("\nID    Name");
					for (UserDetails userDetails : service.getUsers()) {
						if (userDetails.getUserType().equalsIgnoreCase("Employee"))
							logger.info("\n" + userDetails.getUserID() + "  | " + userDetails.getUserName() );
					}
					break;
				case "2":
					logger.info("\nID  |  Name         | Cost/Unit ");
					for (Assets assets2 : service.getAssets()) {
						logger.info("\n" + assets2.getAssetID() + " | " + assets2.getAssetName() + " | "
								+ assets2.getAssetCost());
					}
					break;
				case "3":
					logger.info("\nEnter the Employee's ID: ");
					Integer empID = Integer.parseInt(scanner.nextLine());
					logger.info("\nEnter the asset ID: ");
					Integer assetID = Integer.parseInt(scanner.nextLine());
					logger.info("\nEnter the quantity: ");
					Integer quantity = Integer.parseInt(scanner.nextLine());
					logger.info("\nEnter additional notes --> \n");
					String addNotes = scanner.nextLine();

					Integer check = 0;
					try {
						check = service.addRequest(empID, user.getUserID(), assetID, quantity, addNotes);
					} catch (AssetNotFoundException e) {
						e.printStackTrace();
					}
					if (check.equals(0))
						logger.info("\nRequest Made!");
					else if (check.equals(1)) {
						logger.info("\nRequest Cancelled...\nEmployee not available in the database");
						logger.info("\nEnter 'y' to insert Employee into database: ");
						if (scanner.nextLine().equalsIgnoreCase("y")) {
							while (true) {
								try {
									logger.info("\nEnter the Username:");
									String userName = scanner.nextLine();
									logger.info("\nEnter the Employee ID");
									String employeeID = scanner.nextLine();
									service.addUser(new UserDetails(userName, "qwerty", "Employee", employeeID));
									break;
								} catch (InvalidUsernameException e) {
									logger.info("\n" + e.getMessage() );
								}
							}
						}
					} else {
						logger.info("\nRequests cannot be made for managers/admin");
					}
					break;
				case "4":
					logger.info("\nForm ID\n");
					for (RequestForm requestForm : service.getRequests()) {
						if (requestForm.getManagerID().equals(user.getUserID()))
							logger.info("\n" +
									requestForm + "Status : " + (requestForm.isAlloted() ? "" : "Not ") + "Alloted\n\n");
					}
					break;
				case "5":
					while (true) {
						try {
							logger.info("\nEnter the Username:");
							String userName = scanner.nextLine();
							logger.info("\nEnter the Employee ID");
							String employeeID = scanner.nextLine();
							service.addUser(new UserDetails(userName, "qwerty", "Employee", employeeID));
							break;
						} catch (InvalidUsernameException e) {
							logger.info("\n" + e.getMessage() );
						}
					}
					break;
				case "6":
					logger.info("\nEnter the Employee's ID of Owner of the asset: ");
					Integer empID1 = Integer.parseInt(scanner.nextLine());
					logger.info("\nEnter the asset ID: ");
					Integer assetID1 = Integer.parseInt(scanner.nextLine());
					logger.info("\nEnter the quantity: ");
					Integer quantity1 = Integer.parseInt(scanner.nextLine());
					Integer check1 = 0;
					try {
						check1 = service.addRequest(empID1, user.getUserID(), assetID1, quantity1 * -1,
								"DESTROYED ASSETS - Please allot to remove");
					} catch (AssetNotFoundException e) {
						e.printStackTrace();
					}
					if (check1.equals(0))
						logger.info("\nRequest Made!");
					else if (check1.equals(1)) {
						logger.info("\nRequest Cancelled...\nEmployee not available in the database");
						logger.info("\nEnter 'y' to insert into database: ");
						if (scanner.nextLine().equalsIgnoreCase("y")) {
							while (true) {
								try {
									logger.info("\nEnter the Username:");
									String userName = scanner.nextLine();
									logger.info("\nEnter the Employee ID");
									String employeeID = scanner.nextLine();
									service.addUser(new UserDetails(userName, "qwerty", "Employee", employeeID));
									break;
								} catch (InvalidUsernameException e) {
									logger.info("\n" + e.getMessage() );
								}
							}
						}
					} else {
						logger.info("\nRequests cannot be made for managers/admin");
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
