package com.tyss.assetmanagement1.util.exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {

	public UserNotFoundException() {
		super("No user found with matching username and password");
	}

}
