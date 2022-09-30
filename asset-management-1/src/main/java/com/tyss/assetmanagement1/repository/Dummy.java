package com.tyss.assetmanagement1.repository;


import java.util.ArrayList;
import java.util.List;

import com.tyss.assetmanagement1.beans.Assets;
import com.tyss.assetmanagement1.beans.RequestForm;
https://github.com/Manishnagi
https://github.com/Manishnagi
https://github.com/Manishnagi
https://github.com/Manishnagi
https://github.com/Manishnagi
https://github.com/Manishnagihttps://github.com/Manishnagi
import com.tyss.assetmanagement1.beans.UserDetails;
import com.tyss.assetmanagement1.util.PasswordEncoder;

public class Dummy {

	public static List<UserDetails> dummyUsers() {

		List<UserDetails> users = new ArrayList<>();

		users.add(new UserDetails("A", PasswordEncoder.encodedPassword("qwerty"), "Admin", "TY8506"));
		users.add(new UserDetails("C", PasswordEncoder.encodedPassword("qwerty"), "Manager", "TY8508"));
		users.add(new UserDetails("D", PasswordEncoder.encodedPassword("qwerty"), "Manager", "TY8509"));
		users.add(new UserDetails("E", PasswordEncoder.encodedPassword("qwerty"), "Manager", "TY8510"));
		users.add(new UserDetails("F", PasswordEncoder.encodedPassword("qwerty"), "Employee", "TY8516"));
		users.add(new UserDetails("G", PasswordEncoder.encodedPassword("qwerty"), "Employee", "TY8526"));
		users.add(new UserDetails("H", PasswordEncoder.encodedPassword("qwerty"), "Employee", "TY8536"));
		users.add(new UserDetails("I", PasswordEncoder.encodedPassword("qwerty"), "Employee", "TY8546"));
		users.add(new UserDetails("J", PasswordEncoder.encodedPassword("qwerty"), "Employee", "TY8556"));
		users.add(new UserDetails("K", PasswordEncoder.encodedPassword("qwerty"), "Employee", "TY8566"));

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
	
	
	public static List<RequestForm> dummyRequests() {		
		
		List<RequestForm> requests = new ArrayList<RequestForm>();
		
		requests.add(new RequestForm(6,1, 1, 681, "High Prioirty"));
		requests.add(new RequestForm(8,1, 2, 28, "High Priority"));
		requests.add(new RequestForm(5,2, 3, 35, "High Priority"));
		requests.add(new RequestForm(5,3, 4, 5, "High Priority"));
		requests.add(new RequestForm(8, 1, 5, 2, "High Priority"));
		requests.add(new RequestForm(5, 2, 6, 29, "High Priority"));
		requests.add(new RequestForm(7, 3, 7, 120, "High Priority"));

		return requests;
	}
	
}
