package com.tyss.assetmanagement1.util.exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {

	public UserNotFoundException() {
		super("User does not exist in the database");
	}
}
