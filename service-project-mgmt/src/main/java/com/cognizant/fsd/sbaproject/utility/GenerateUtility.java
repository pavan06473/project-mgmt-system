package com.cognizant.fsd.sbaproject.utility;

/**
 * StringUtility 
 *
 * @author  Ritesh Choudhary
 * @version 1.0
 * @ Auto Generated Project Kickstart
 */


public class GenerateUtility{
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";

	public static long generateTenNumber() {
		long theRandomNum = (long) (Math.random()*Math.pow(10,10));
		return theRandomNum;
	}	

	public static String generate10DigitAplha() {
		StringBuilder builder = new StringBuilder();
		for(int i =0 ;i <10 ; i++) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}	

}
