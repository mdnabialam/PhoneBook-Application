package com.phone.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class PhoneBookHalderException {

	@ExceptionHandler(value = PhoneBookException.class)
	public String handelPhonebookException() {
		return "error";
	}
	/*
	@ExceptionHandler(value = NullPointerException.class)
	public String handelNPE() {
		return "error";
	}
	*/
}
