package com.tyss.assetmanagement1.repository;

import java.util.ArrayList;
import java.util.List;

import com.tyss.assetmanagement1.beans.Assets;
import com.tyss.assetmanagement1.beans.UserDetails;

public class Dummy {

	public static List<UserDetails> dummyUsers() {

		List<UserDetails> users = new ArrayList<>();

		users.add(new UserDetails("A", "qwerty", "Admin", "TY8506"));
		users.add(new UserDetails("B", "qwerty", "Admin", "TY8507"));
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
	
	public static void allot(List<Assets> assets) {
		
		assets.get(0).allotManager(2, 195);
		assets.get(0).allotManager(3, 280);
		assets.get(0).allotEmployee(4, 10);
		assets.get(1).allotManager(2, 40);
		assets.get(1).allotEmployee(5, 20);
		assets.get(1).allotEmployee(8, 58);
		assets.get(2).allotManager(3, 18);
		assets.get(2).allotEmployee(6, 8);
		assets.get(3).allotManager(2, 30);
		assets.get(3).allotEmployee(9, 5);
		assets.get(4).allotManager(2, 5);
		assets.get(5).allotManager(3, 80);
		assets.get(6).allotEmployee(4, 10);
		assets.get(6).allotEmployee(10, 60);
		assets.get(7).allotManager(2, 68);
		assets.get(8).allotManager(3, 80);
		assets.get(8).allotEmployee(7, 152);
		
		
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
