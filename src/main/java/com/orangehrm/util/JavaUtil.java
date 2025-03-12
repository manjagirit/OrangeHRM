package com.orangehrm.util;

import org.apache.commons.lang3.RandomStringUtils;

public class JavaUtil {
	
	public static String randomAlphabets() {
		return RandomStringUtils.randomAlphabetic(6);
	}
	
	public static String randomNumbers() {
		return RandomStringUtils.randomNumeric(3);
	}
	
	public static String randomAlphaNum() {
		String Alpha = RandomStringUtils.randomAlphabetic(5);
		String Num = RandomStringUtils.randomNumeric(3);
		return(Alpha+Num);
	}
	
	public static void convertToInt(String element) {
		Integer.parseInt(element);
	}

}
