package com.tyss.assetmanagement1.controllers;

import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.tyss.assetmanagement1.beans.UserDetails;
import com.tyss.assetmanagement1.service.Service;
import com.tyss.assetmanagement1.util.exceptions.InvalidPasswordException;
import com.tyss.assetmanagement1.util.factory.Factory;


/**
 * The main controller which redirects to 
 * either admin controller or user controller 
 * according to the type of user who has logged in
 * 
 * @author C J Rohan
 *
 */
public class MainController {

	private MainController() {
		
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Service service = Factory.getService();
		
		Logger logger = Logger.getLogger(MainController.class);
		BasicConfigurator.configure();
		do {
			
			try {
				// To get user name and password for login
				logger.info("\nEnter your login details");
				logger.info("\nEnter your User Name: ");
				String userName = scanner.nextLine().strip();
				logger.info("\nEnter your password: ");
				String password = scanner.nextLine();
				
				// searching for the user
				UserDetails user = service.getUser(userName, password);

				// logging in with respective controller...
				if (user != null) {
					switch (user.getUserType()) {
					case "Admin":
						AdminController.controller(user, service, scanner);
						break;
					case "Admin":
						AdminController.controller(user, service, scanner);
						break;
					case "Manager":
						ManagerController.controller(user, service, scanner);
						break;
					case "Employee":
						logger.info("\nLogin not available for employee.......");
						break;
					case "Admin":
						AdminController.controller(user, service, scanner);
						break;
					default:
						logger.info("\nThis will be avoided always...");
					}
				} else {
					logger.info("\nEnter a valid username and correct password");
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (InvalidPasswordException e) {
				e.printStackTrace();
			}
			logger.info("\nEnter 'y' to login again: ");

		} while (scanner.nextLine().strip().equalsIgnoreCase("y"));

		scanner.close();
	}

}
