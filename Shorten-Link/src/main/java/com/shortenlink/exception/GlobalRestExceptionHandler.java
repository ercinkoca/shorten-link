package com.shortenlink.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler({GenericException.class})
	public ResponseEntity handleCustomException(GenericException ex) {
		
		
		if (ex instanceof NotFoundException  ) {
			ApiResponse err = new ApiResponse(ex.getCode(), ex.getGmessage(), ex.getLocalizedMessage());
			return new ResponseEntity(err, HttpStatus.NOT_FOUND);
		} else if (ex instanceof BadRequestException) {
			ApiResponse err = new ApiResponse(ex.getCode(), ex.getGmessage(), ex.getLocalizedMessage());
			return new ResponseEntity(err, HttpStatus.BAD_REQUEST);
		}
		else  {
			ApiResponse err = new ApiResponse(-3000, "Application Error", ex.toString());
			return new ResponseEntity(err, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ExceptionHandler({Exception.class})
	public ResponseEntity handleCustomException2(Exception ex) {
		
		
		ApiResponse err = new ApiResponse(-3000, "Application Error", ex.toString());
		return new ResponseEntity(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

}
