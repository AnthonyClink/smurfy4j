package com.clinkworks.mechwarrior.exception;

public class SmurfyAuthorizationException extends RuntimeException {

	private static final long serialVersionUID = -5687954990154480832L;

	public SmurfyAuthorizationException(String apiKey){
		super("The Smurfy api key stored on your clinkworks account is " + apiKey + " please validate and update your information");
	}
	
}
