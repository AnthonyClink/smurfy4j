package com.clinkworks.mechwarrior.service;

import com.clinkworks.mechwarrior.authentication.AuthenticationService;
import com.clinkworks.mechwarrior.authentication.AuthenticationToken;
import com.clinkworks.mechwarrior.data.UserData;
import com.clinkworks.mechwarrior.datatype.UserDetails;
import com.clinkworks.mechwarrior.domain.User;
import com.clinkworks.mechwarrior.util.MechwarriorComponentFactory;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

@Singleton
public class UserService {
	
	private final AuthenticationService authenticationService;
	private final MechwarriorComponentFactory mcf;
	private final UserData userData;
	private final SmurfyMechBayService smurfyMechBayService;
	private final LocalMechBayService localMechBayService;
	
	@Inject
	public UserService(UserData userData, LocalMechBayService localMechBayService, SmurfyMechBayService smurfyMechBayService, AuthenticationService authenticationService, MechwarriorComponentFactory mechwarriorComponentFactory){
		mcf = mechwarriorComponentFactory;
		this.userData = userData;
		this.authenticationService = authenticationService;
		this.localMechBayService = localMechBayService;
		this.smurfyMechBayService = smurfyMechBayService;
	}
	
	public User createUser(UserDetails userDetails){
		saveUserDetails(userDetails);
		userDetails.setPassword(null);
		return new User(userDetails);
	}
	
	public User createUser(String emailAddress, String password, String smurfyApiKey){
		UserDetails userDetails = new UserDetails();
		userDetails.setEmailAddress(emailAddress);
		userDetails.setPassword(password);
		userDetails.setSmurfyApiKey(smurfyApiKey);
		saveUserDetails(userDetails);
		userDetails.setPassword(null);
		return new User(userDetails);
	}
	
	@Transactional
	void saveUserDetails(UserDetails userDetails){
		userData.saveUser(userDetails);
		boolean smurfyAuthenticated = authenticationService.authenticateSmurfyAccess(userDetails.getSmurfyApiKey());
		AuthenticationToken authenticationToken = mcf.createAuthenticationToken(userDetails.getSmurfyApiKey(), smurfyAuthenticated, true);
		userDetails.setAuthenticationToken(authenticationToken);
	}
	
}
