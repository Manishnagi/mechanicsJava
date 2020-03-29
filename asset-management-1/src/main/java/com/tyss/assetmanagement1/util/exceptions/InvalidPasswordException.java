package com.tyss.assetmanagement1.util.exceptions;

@SuppressWarnings("serial")
public class InvalidPasswordException extends Exception {

	public InvalidPasswordException() {
		super("Password Mismatch");
	}
	
	public InvalidPasswordException(String string) {
		super(string);
	}

}
