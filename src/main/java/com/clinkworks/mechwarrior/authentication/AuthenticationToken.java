package com.clinkworks.mechwarrior.authentication;

import java.util.UUID;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

public class AuthenticationToken {

	private final String authenticationId;
	private final boolean smurfyAuthenticated;
	private final boolean clinkworksAuthenticated;
	private final String smurfyApiKey;
	
	@Inject
	AuthenticationToken(@Assisted("smurfyApiKey") String smurfyApiKey, @Assisted("smurfyAuthenticated") Boolean smurfyAuthenticated, @Assisted("clinkworksAuthenticated") Boolean clinkworksAuthenticated){
		authenticationId = UUID.randomUUID().toString();
		this.smurfyApiKey = smurfyApiKey;
		this.smurfyAuthenticated = smurfyAuthenticated;
		this.clinkworksAuthenticated = clinkworksAuthenticated;
	}
	
	public String getAuthenticationId(){
		return authenticationId;
	}
	
	public boolean isClinkworksAuthenticated() {
		return clinkworksAuthenticated;
	}
	
	public boolean isSmurfyAuthenticated(){
		return smurfyAuthenticated;
	}

	public String getSmurfyApiKey() {
		return smurfyApiKey;
	}

}
