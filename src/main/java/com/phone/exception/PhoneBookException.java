package com.phone.exception;

@SuppressWarnings("serial")
public class PhoneBookException extends RuntimeException {
	
	public PhoneBookException() {
		
	}
	
	public PhoneBookException(String msg) {
		super(msg);
	}

}
