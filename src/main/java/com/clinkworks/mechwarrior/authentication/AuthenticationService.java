package com.clinkworks.mechwarrior.authentication;

import org.eclipse.jetty.util.security.Credential.MD5;

import com.clinkworks.mechwarrior.data.SmurfyMechData;
import com.clinkworks.mechwarrior.data.UserData;
import com.clinkworks.mechwarrior.util.MechwarriorComponentFactory;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class AuthenticationService {
	
	//every good piece of software needs at least 1 acronym
	private final MechwarriorComponentFactory mcf;
	private final UserData userData;
	private final SmurfyMechData smurfyMechData;
	
	@Inject
	public AuthenticationService(SmurfyMechData smurfyMechData, UserData userData, MechwarriorComponentFactory mechwarriorComponentFactory){
		this.userData = userData;
		mcf = mechwarriorComponentFactory;
		this.smurfyMechData = smurfyMechData;
	}
	
	public boolean authenticateSmurfyAccess(String apiKey){
		return smurfyMechData.getSmurfyUserName(apiKey) != null;
	}

	public AuthenticationToken authenticate(String email, String encryptedPassword) {
		
		String decryptedPassword = MD5.digest(encryptedPassword);
		String apiKey = userData.getApiKeyForEmailAddressAndPassword(email, decryptedPassword);
		decryptedPassword = null;
		
		boolean clinkworksAuthenticated = apiKey != null;
		boolean smurfyAuthenticated = false;
		
		if(clinkworksAuthenticated){
			smurfyAuthenticated = authenticateSmurfyAccess(apiKey);
		}
		
		return mcf.createAuthenticationToken(apiKey, smurfyAuthenticated, clinkworksAuthenticated);
	}
	
}
