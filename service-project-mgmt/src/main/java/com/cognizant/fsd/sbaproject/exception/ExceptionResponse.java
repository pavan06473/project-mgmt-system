package com.cognizant.fsd.sbaproject.exception;

/**
* ExceptionResponse 
*
* @author  Ritesh Choudhary
* @version 1.0
* @ Auto Generated Project Kickstart
*/

public class ExceptionResponse {

	private String errorCode;
	private String errorInfo;
	private String errorStatus;

	public ExceptionResponse(DataAccessException e) {
		super();
		this.errorCode = e.getErrorCode();
		this.errorInfo = e.getErrorCode();
		this.errorStatus = e.getErrorStatus();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	public String getErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(String errorStatus) {
		this.errorStatus = errorStatus;
	}

}
