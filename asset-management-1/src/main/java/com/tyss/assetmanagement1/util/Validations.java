package com.tyss.assetmanagement1.util;

public class Validations {

	private Validations() {

	}
	
	public static boolean validUsername(String name) {
		return name.matches("[A-Za-z\\.\\s]{6,30}");
	}

	public static boolean validPassword(String password) {
		return password.matches("[(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W])]{6,20}");
	}
	
}
