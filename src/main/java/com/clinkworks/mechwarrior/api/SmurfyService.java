package com.clinkworks.mechwarrior.api;

import com.clinkworks.mechwarrior.data.SmurfyMechData;
import com.clinkworks.mechwarrior.modules.SmurfyClientModule;
import com.clinkworks.mechwarrior.service.MechBayService;
import com.clinkworks.mechwarrior.service.SmurfyMechBayService;
import com.sun.jersey.api.client.Client;

//using singleton pattern to provide smurfy service for
// non guice users
public class SmurfyService {
	private static final MechBayService mechBayService;
	
	static{
		SmurfyClientModule smurfyClientModule = new SmurfyClientModule();
		Client client = smurfyClientModule.smurfyClient();
		mechBayService = new SmurfyMechBayService(new SmurfyMechData(client, "b2155092c5cb79b39e2a5941c721ce3278d7e22a"));
	}
	
	public static final synchronized MechBayService getInstance(){
		return mechBayService;
	}
}
