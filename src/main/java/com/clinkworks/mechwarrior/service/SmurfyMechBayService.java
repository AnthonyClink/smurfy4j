package com.clinkworks.mechwarrior.service;

import com.clinkworks.mechwarrior.authentication.AuthenticationService;
import com.clinkworks.mechwarrior.data.MechData;
import com.clinkworks.mechwarrior.data.SmurfyMechData;
import com.clinkworks.mechwarrior.datatype.Loadout;
import com.clinkworks.mechwarrior.datatype.Mech;
import com.clinkworks.mechwarrior.datatype.Mechs;
import com.clinkworks.mechwarrior.domain.MechBay;
import com.clinkworks.mechwarrior.domain.User;
import com.clinkworks.mechwarrior.exception.SmurfyAuthorizationException;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class SmurfyMechBayService implements MechBayService{
	
	private final MechData mechData;
	private final AuthenticationService authenticationService;
	
	@Inject
	public SmurfyMechBayService(SmurfyMechData mechData, AuthenticationService authenticationService){
		this.mechData = mechData;
		this.authenticationService = authenticationService;
	}
	
	@Override
	public Mech getStockMech(int mechId) {
		Loadout loadout = mechData.getLoadoutForChassisId("stock", mechId);
		Mech mech = mechData.getChassisDetailsForSpecificChassisId(mechId);
		mech.setLoadout(loadout);
		return mech;
	}

	@Override 
	public Mech getMechWithSpecificLoadout(int mechId, String loadoutId){
		Loadout loadout = mechData.getLoadoutForChassisId(loadoutId, mechId);
		Mech mech = mechData.getChassisDetailsForSpecificChassisId(mechId);
		mech.setLoadout(loadout);
		return mech;
	}
	
	@Override
	public Mechs getAllMechs() {
		return mechData.getDetailsForAllChassis();
	}


	@Override
	public MechBay getMechBay(String smurfyApiKey) {
		if(!authenticationService.authenticateSmurfyAccess(smurfyApiKey)){
			throw new SmurfyAuthorizationException(smurfyApiKey);
		}		
		return mechData.getMechBay(smurfyApiKey);
	}
	
	@Override
	public MechBay getMechBay(User user) {
		if(!user.isSmurfyAuthenticated()){
			throw new SmurfyAuthorizationException(user.getSmurfyApiKey());
		}
		return mechData.getMechBay(user.getSmurfyApiKey());
	}



}
