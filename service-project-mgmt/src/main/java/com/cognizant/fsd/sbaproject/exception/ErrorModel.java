package com.cognizant.fsd.sbaproject.exception;

import org.springframework.stereotype.Component;

/**
* ErrorModel 
*
* @author  Ritesh Choudhary
* @version 1.0
* @ Auto Generated Project Kickstart
*/

@Component
public class ErrorModel {

	private String requestStatus;
	private String resultCode;
	private String resultInfo;

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultInfo() {
		return resultInfo;
	}

	public void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	}

	@Override
	public String toString() {
		return "ErrorModel [requestStatus=" + requestStatus + ", resultCode=" + resultCode + ", resultInfo="
				+ resultInfo + "]";
	}

	public ErrorModel(String requestStatus, String resultCode, String resultInfo) {
		super();
		this.requestStatus = requestStatus;
		this.resultCode = resultCode;
		this.resultInfo = resultInfo;
	}

	public ErrorModel() {
		super();
	}
}
