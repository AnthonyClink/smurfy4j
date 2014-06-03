package com.clinkworks.mechwarrior.domain;

import com.clinkworks.mechwarrior.authentication.AuthenticationToken;
import com.clinkworks.mechwarrior.datatype.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {

	@JsonIgnore
	private final UserDetails userDetails;

	public User(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	
	public User(){
		this.userDetails = new UserDetails();
	}
	
	public int getId(){
		return getUserDetails().getId();
	}
	
	public boolean isSmurfyAuthenticated(){
		return getUserDetails().isSmurfyAuthenticated();
	}
	
	public boolean isClinkworksAuthenticated(){
		return getUserDetails().isClinkworksAuthenticated();
	}

	public String getEmailAddress() {
		return getUserDetails().getEmailAddress();
	}

	public void setEmailAddress(String emailAddress) {
		getUserDetails().setEmailAddress(emailAddress);
	}

	public String getSmurfyApiKey() {
		return getUserDetails().getSmurfyApiKey();
	}

	public void setSmurfyApiKey(String smurfyApiKey) {
		getUserDetails().setSmurfyApiKey(smurfyApiKey);
	}
	
	public AuthenticationToken getAuthenticationToken(){
		return getUserDetails().getAuthenticationToken();
	}
	
	public void setAuthenticationToken(AuthenticationToken authenticationToken){
		getUserDetails().setAuthenticationToken(authenticationToken);
	}
	
	@JsonIgnore
	public UserDetails getUserDetails(){
		return userDetails;
	}

}
