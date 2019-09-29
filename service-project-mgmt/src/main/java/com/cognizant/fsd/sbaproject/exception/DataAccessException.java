package com.cognizant.fsd.sbaproject.exception;

/**
* DataAccessException 
*
* @author  Ritesh Choudhary
* @version 1.0
* @ Auto Generated Project Kickstart
*/

public class DataAccessException extends Exception {

	/**
	* 
	*/
	private static final long serialVersionUID = 2093851095060730335L;
	private String errorCode;
	private String errorStatus;

	public DataAccessException(String errorCode, String errorStatus) {
		this.errorCode = errorCode;
		this.errorStatus = errorStatus;

	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(String errorStatus) {
		this.errorStatus = errorStatus;
	}
}
