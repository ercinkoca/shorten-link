package com.shortenlink.exception;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class GenericException extends RuntimeException {


	private static final long serialVersionUID = -7337243474859670912L;
	private int code;
	private String  message;
	private String details;
	
	public GenericException(int code, String message) {
		
		super(message);
		this.code = code;
		this.message = message;
	
	}
	
	public GenericException(int code, String message,String details) {
		
		super(details);
		this.code = code;
		this.message = message;
		this.details=details;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getGmessage() {
		return message;
	}

	public void setGmessage(String message) {
		this.message = message;
	}

	public GenericException() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getDetails() {
		return details;
	}



	public void setDetails(String details) {
		this.details = details;
	}
	
}
