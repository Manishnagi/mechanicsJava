package com.tyss.assetmanagement1.util.exceptions;

@SuppressWarnings("serial")
public class AssetNotFoundException extends Exception {
	
	public AssetNotFoundException() {
		super("Invalid asset name / price");
	}

}
