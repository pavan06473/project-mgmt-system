package com.cognizant.fsd.sbaproject.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.fsd.sbaproject.exception.DataAccessException;
import com.cognizant.fsd.sbaproject.exception.ErrorModel;
import com.cognizant.fsd.sbaproject.model.JSONResponseModel;

@RequestMapping("/api")
@CrossOrigin("*")
public abstract class AbstractController {

	protected final String RESPONSE_STATUS_OK = String.valueOf(HttpServletResponse.SC_OK);
	protected final String RESPONSE_STATUS_ERROR = String.valueOf(HttpServletResponse.SC_BAD_REQUEST);
	protected final String RESPONSE_ERROR = String.valueOf(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

	protected final String RESPONSE_SUCCESS = "SUCCESS";
	protected final String RESPONSE_FAILURE = "FAILURE";

	protected final String REQUESTSTATUS_DISPLAY = "DISPLAY";
	protected final String REQUESTSTATUS_NOTDISPLAY = "NOTDISPLAY";

	protected final String GENERAL_ERROR = "Sorry, we are facing technical issues right now. Please try again later";


	protected final JSONResponseModel setJSONResponseVO(Object responseResult, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");

		JSONResponseModel jsonResponseModel = new JSONResponseModel();
		jsonResponseModel.setData(responseResult);
		jsonResponseModel.setStatus(RESPONSE_SUCCESS);

		return jsonResponseModel;
	}

	protected final JSONResponseModel setJSONResponseVO(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");

		JSONResponseModel jsonResponseModel = new JSONResponseModel();
		jsonResponseModel.setStatus(RESPONSE_SUCCESS);

		return jsonResponseModel;
	}

	protected final JSONResponseModel setJSONResponseVOFailed(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");

		JSONResponseModel jsonResponseModel = new JSONResponseModel();

		jsonResponseModel.setStatus(RESPONSE_FAILURE);
		return jsonResponseModel;
	}

	protected final JSONResponseModel setJSONResponseVOFailed(HttpServletResponse response, DataAccessException e) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		JSONResponseModel jsonResponseModel = new JSONResponseModel();

		ErrorModel errorModel = new ErrorModel();
		errorModel.setResultCode(e.getErrorCode());
		errorModel.setResultInfo(e.getErrorCode());
		errorModel.setRequestStatus(REQUESTSTATUS_NOTDISPLAY);
		jsonResponseModel.setErrorModel(errorModel);

		jsonResponseModel.setStatus(RESPONSE_FAILURE);
		return jsonResponseModel;
	}

	protected final JSONResponseModel setJSONResponseVOFailed(HttpServletResponse response, Exception e) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		JSONResponseModel jsonResponseModel = new JSONResponseModel();

		ErrorModel errorModel = new ErrorModel();
		errorModel.setResultCode(e.getMessage());
		errorModel.setRequestStatus(REQUESTSTATUS_DISPLAY);
		jsonResponseModel.setErrorModel(errorModel);

		jsonResponseModel.setStatus(RESPONSE_FAILURE);
		return jsonResponseModel;
	}

	protected final JSONResponseModel setJSONResponseVOFailedGeneral(HttpServletResponse response, Exception e) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		JSONResponseModel jsonResponseModel = new JSONResponseModel();

		ErrorModel errorModel = new ErrorModel();
		errorModel.setResultCode(GENERAL_ERROR);
		errorModel.setResultInfo(GENERAL_ERROR);
		errorModel.setRequestStatus(REQUESTSTATUS_DISPLAY);
		jsonResponseModel.setErrorModel(errorModel);

		jsonResponseModel.setStatus(RESPONSE_FAILURE);
		return jsonResponseModel;
	}	

	protected final JSONResponseModel setJSONResponseVOFailed(HttpServletResponse response, ErrorModel errorModel) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		JSONResponseModel jsonResponseModel = new JSONResponseModel();

		jsonResponseModel.setErrorModel(errorModel);

		jsonResponseModel.setStatus(RESPONSE_FAILURE);
		return jsonResponseModel;
	}

	protected final JSONResponseModel setJSONResponseVOFailed(HttpServletResponse response, String errorCode, String errorMsg) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		JSONResponseModel jsonResponseModel = new JSONResponseModel();

		ErrorModel errorModel = new ErrorModel();
		errorModel.setResultCode(errorCode);
		errorModel.setResultInfo(errorMsg);
		errorModel.setRequestStatus(REQUESTSTATUS_DISPLAY);

		jsonResponseModel.setErrorModel(errorModel);

		jsonResponseModel.setStatus(RESPONSE_FAILURE);
		return jsonResponseModel;
	}

}
