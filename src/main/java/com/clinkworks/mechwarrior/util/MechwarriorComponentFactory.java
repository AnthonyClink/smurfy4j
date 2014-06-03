package com.clinkworks.mechwarrior.util;

import com.clinkworks.mechwarrior.authentication.AuthenticationToken;
import com.clinkworks.mechwarrior.datatype.UserDetails;
import com.google.inject.assistedinject.Assisted;

public interface MechwarriorComponentFactory {
	public AuthenticationToken createAuthenticationToken(@Assisted("smurfyApiKey") String smurfyApiKey, @Assisted("smurfyAuthenticated") Boolean smurfyAuthenticated, @Assisted("clinkworksAuthenticated") Boolean clinkworksAuthenticated);
	public UserDetails createUserDetails(AuthenticationToken authenticationToken);
} 
