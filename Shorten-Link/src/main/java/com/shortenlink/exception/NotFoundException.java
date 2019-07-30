package com.shortenlink.exception;

public class NotFoundException extends GenericException {

	private static final long serialVersionUID = 1756662905782096582L;
	
	public NotFoundException(int code, String message) {
		super(code, message);
	
	}
	
	public NotFoundException(int code, String message,String details) {
		super(code, message,details);
	
	}

	public NotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}


}
