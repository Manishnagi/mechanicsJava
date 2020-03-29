package com.tyss.assetmanagement1.util.exceptions;

@SuppressWarnings("serial")
public class InvalidUsernameException extends Exception {
	
	public InvalidUsernameException() {
		super("Name cannot contain numbers or special characters");
	}

}
