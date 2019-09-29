package com.cognizant.fsd.sbaproject.utility;

/**
 * StringUtility 
 *
 * @author  Ritesh Choudhary
 * @version 1.0
 * @ Auto Generated Project Kickstart
 */


public class StringUtility{


	public static boolean isNullOrEmpty(String str){
		if (str == null || str.length() == 0){
			return true;
		} else {
			return false;
		}
	}
	public static boolean verifyString(String val) {
		boolean valid = false;
		if(null != val) {
			valid = true;
		}
		return valid;
	}


	public static boolean validate(String input) {
		boolean valid = false;

		if(null!=input && input.trim().length()>0) {
			valid= true;
		}
		return valid;
	}

}	
