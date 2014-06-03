package com.clinkworks.mechwarrior.service;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.clinkworks.mechwarrior.datatype.UserDetails;
import com.clinkworks.mechwarrior.domain.User;
import com.clinkworks.mechwarrior.modules.MechwarriorModule;
import com.clinkworks.neptical.junit.runners.NepticalJUnit4Runner;
import com.clinkworks.neptical.junit.runners.NepticalJUnit4Runner.NepticalConfiguration;
import com.google.inject.persist.PersistService;

@RunWith(NepticalJUnit4Runner.class)
@NepticalConfiguration({MechwarriorModule.class})
public class UserServiceIntegrationTest {
	
	@Before
	public void setup(PersistService persistService){
		persistService.start();
	}
	
	@Test
	public void testCreateUserEnsuresProperSecurityMesuresAreTaken(UserService userService){
		UserDetails userDetails = new UserDetails();
		userDetails.setPassword("caZeHFNJ1092r"); //password must be incrypted
		assertNotEquals(userDetails.getPassword(), "caZeHFNJ1092r");
		userDetails.setEmailAddress(UUID.randomUUID().toString());
		userDetails.setSmurfyApiKey("8fc37d9ade5501c958a9a9bf7f61904dc71bf1a4");
		User user = userService.createUser(userDetails);
		assertTrue(user.isClinkworksAuthenticated()); //new users should be authenticated
		assertTrue(user.isSmurfyAuthenticated()); //api key should be valid
		assertNull(user.getUserDetails().getPassword()); //password cannot be retrieved by any means
		assertNull(userDetails.getPassword()); //password cannot be retrieved by any means
	}
	
}
