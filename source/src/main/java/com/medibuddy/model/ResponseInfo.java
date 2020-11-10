package com.medibuddy.model;

import java.util.ArrayList;

/**
 * @author Prasanna
 *
 */
public class ResponseInfo {

	private Boolean status;
	private int statusCode;
	private String message;
	private Object response;
	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}
	/**
	 * @return the errorCode
	 */
	public int getStatusCode() {
		return statusCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the response
	 */
	public Object getResponse() {
		return response;
	}
	/**
	 * @param response the response to set
	 */
	public void setResponse(Object response) {
		this.response = response;
	}

	
	
	
}
