package com.clinkworks.mechwarrior.exception;

import com.google.gson.JsonSyntaxException;

public class ApiConversionException extends RuntimeException{

	public ApiConversionException(String message, JsonSyntaxException e) {
		super(message, e);
	}

	private static final long serialVersionUID = -7115521490475579954L;

}
