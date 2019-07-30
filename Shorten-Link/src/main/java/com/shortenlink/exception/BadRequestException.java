package com.shortenlink.exception;

public class BadRequestException extends GenericException {

	private static final long serialVersionUID = 1756662905782096582L;
	
	public BadRequestException(int code, String message) {
		super(code, message);
	
	}
	
	public BadRequestException(int code, String message,String details) {
		super(code, message,details);
	
	}

	public BadRequestException() {
		super();
		// TODO Auto-generated constructor stub
	}


}
