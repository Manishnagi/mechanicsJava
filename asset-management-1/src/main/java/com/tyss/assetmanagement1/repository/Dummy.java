package com.tyss.assetmanagement1.repository;


import java.util.ArrayList;
import java.util.List;

import com.tyss.assetmanagement1.beans.Assets;
import com.tyss.assetmanagement1.beans.UserDetails;
import com.tyss.assetmanagement1.service.Service;
import com.tyss.assetmanagement1.util.exceptions.AssetNotFoundException;
import com.tyss.assetmanagement1.util.exceptions.QuantityNotAvailableException;
import com.tyss.assetmanagement1.util.exceptions.RequestNotFoundException;

public class Dummy {

	public static List<UserDetails> dummyUsers() {

		List<UserDetails> users = new ArrayList<>();

		users.add(new UserDetails("A", "qwerty", "Admin", "TY8506"));
		users.add(new UserDetails("C", "qwerty", "Manager", "TY8508"));
		users.add(new UserDetails("D", "qwerty", "Manager", "TY8509"));
		users.add(new UserDetails("E", "qwerty", "Manager", "TY8510"));
		users.add(new UserDetails("F", "qwerty", "Employee", "TY8516"));
		users.add(new UserDetails("G", "qwerty", "Employee", "TY8526"));
		users.add(new UserDetails("H", "qwerty", "Employee", "TY8536"));
		users.add(new UserDetails("I", "qwerty", "Employee", "TY8546"));
		users.add(new UserDetails("J", "qwerty", "Employee", "TY8556"));
		users.add(new UserDetails("K", "qwerty", "Employee", "TY8566"));

		return users;

	}
	
	public static List<Assets> dummyAssets() {

		List<Assets> assets = new ArrayList<>();

		assets.add(new Assets("Plastic Chair", 780, 56.0));
		assets.add(new Assets("Recliner", 78, 560.0));
		assets.add(new Assets("Monitor Screen", 25, 5600.0));
		assets.add(new Assets("Keyboard", 35, 126.0));
		assets.add(new Assets("Copper Water Bottle", 12, 1256.0));
		assets.add(new Assets("Tupperware Water Bottle", 90, 199.0));
		assets.add(new Assets("Bag", 120, 689.99));
		assets.add(new Assets("Roller Chair", 70, 559.0));
		assets.add(new Assets("Desks", 151, 596.0));
			
		return assets;

	}
	


	public static void approve(Service service) {
		
		try {
			service.allot(1);
			service.allot(2);
			service.allot(3);
			service.allot(5);
			service.allot(6);
		} catch (QuantityNotAvailableException e) {
			e.printStackTrace();
		} catch (RequestNotFoundException e) {
			e.printStackTrace();
		} catch (AssetNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void request(Service service) {
		
		try {
		service.addRequest(6,1, 1, 780, "High Prioirty");
		service.addRequest(8,1, 2, 78, "High Priority");
		service.addRequest(5,2, 3, 25, "High Priority");
		service.addRequest(5,3, 4, 35, "High Priority" );
		service.addRequest(8, 1, 5, 12, "High Priority");
		service.addRequest(5, 2, 6, 90, "High Priority");
		service.addRequest(7, 3, 7, 120, "High Priority");
		} catch (AssetNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
