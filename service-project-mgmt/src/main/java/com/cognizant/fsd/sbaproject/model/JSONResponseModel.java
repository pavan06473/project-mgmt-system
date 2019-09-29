package com.cognizant.fsd.sbaproject.model;

import java.io.Serializable;

import com.cognizant.fsd.sbaproject.exception.ErrorModel;


/**
 * JSONResponseModel 
 *
 * @author  Ritesh Choudhary
 * @version 1.0
 * @ Auto Generated Project Kickstart
 */

public class JSONResponseModel implements Serializable {

	private Object data;
	private String status ="success";
	private ErrorModel errorModel;
	private String outputMsg;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public ErrorModel getErrorModel() {
		return errorModel;
	}

	public void setErrorModel(ErrorModel errorModel) {
		this.errorModel = errorModel;
	}

	@Override
	public String toString() {
		return "JSONResponseModel [data=" + data + "]";
	}

	public String getOutputMsg() {
		return outputMsg;
	}

	public void setOutputMsg(String outputMsg) {
		this.outputMsg = outputMsg;
	}



}
