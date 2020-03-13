package com.tyss.assetmanagement1.util.exceptions;

@SuppressWarnings("serial")
public class QuantityNotAvailableException extends Exception {

	public QuantityNotAvailableException() {
		super("Available quantity lesser than requested");
	}

}
