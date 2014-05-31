package com.clinkworks.mechwarrior.api;

import com.clinkworks.mechwarrior.data.SmurfyMechData;
import com.clinkworks.mechwarrior.datatype.Mech;
import com.clinkworks.mechwarrior.datatype.Mechs;
import com.clinkworks.mechwarrior.domain.MechBay;
import com.clinkworks.mechwarrior.modules.SmurfyClientModule;
import com.clinkworks.mechwarrior.service.MechBayService;
import com.clinkworks.mechwarrior.service.SmurfyMechBayService;
import com.sun.jersey.api.client.Client;

//using singleton pattern to provide smurfy service for
// non guice users
public class SmurfyService implements MechBayService{
	private static final MechBayService mechBayService;
	
	static{
		SmurfyClientModule smurfyClientModule = new SmurfyClientModule();
		Client client = smurfyClientModule.smurfyClient();
		//I haven't decided how I wanted to handle auth, so for now I made a generic clinkworks account.
		mechBayService = new SmurfyMechBayService(new SmurfyMechData(client, "b2155092c5cb79b39e2a5941c721ce3278d7e22a"));
	}
	
	public static final synchronized MechBayService getInstance(){
		return mechBayService;
	}

	private SmurfyService(){
		//noOp, delegated to SmurfyMechBayService 
	}
	
	@Override
	public Mech getStockMech(int mechId) {
		return getInstance().getStockMech(mechId);
	}

	@Override
	public Mechs getAllMechs() {
		return getInstance().getAllMechs();
	}

	@Override
	public MechBay getMechBay() {
		return getInstance().getMechBay();
	}

	@Override
	public Mech getMechWithSpecificLoadout(int mechId, String loadoutId) {
		return getInstance().getMechWithSpecificLoadout(mechId, loadoutId);
	}
}
