package com.cognizant.fsd.sbaproject.exception;

/**
* ErrorResponseModel 
*
* @author  Ritesh Choudhary
* @version 1.0
* @ Auto Generated Project Kickstart
*/

public class ErrorResponseModel {

	private Object error;

	public Object getError() {
		return error;
	}

	public void setError(Object error) {
		this.error = error;
	}

	public ErrorResponseModel(Object error) {
		super();
		this.error = error;
	}

	@Override
	public String toString() {
		return "ErrorResponseModel [error=" + error + "]";
	}
	
	

}
