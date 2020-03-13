package com.tyss.assetmanagement1.util.exceptions;

@SuppressWarnings("serial")
public class RequestNotFoundException extends Exception {

	public RequestNotFoundException() {
		super("Invalid Request ID");
	}

}
