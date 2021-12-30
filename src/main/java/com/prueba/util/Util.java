package com.prueba.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

	public static final Pattern VALID_EMAIL_ADDRESS = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static final Pattern VALID_PASSWORD = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,8}$",
			Pattern.CASE_INSENSITIVE);

	public static boolean validadorEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS.matcher(emailStr);
		return matcher.find();
	}

	public static boolean validadorPassword(String pass) {
		Matcher matcher = VALID_PASSWORD.matcher(pass);
		return matcher.find();
	}

}
