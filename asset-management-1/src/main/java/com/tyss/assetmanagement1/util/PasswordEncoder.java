package com.tyss.assetmanagement1.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncoder {

	private PasswordEncoder() {

	}
	
	public static boolean checkPassword(String plaintext, String hashed) {
		return BCrypt.checkpw(plaintext, hashed);
	}
	
	public static String encodedPassword(String plaintext) {
		return BCrypt.hashpw(plaintext, BCrypt.gensalt());
	}

}
