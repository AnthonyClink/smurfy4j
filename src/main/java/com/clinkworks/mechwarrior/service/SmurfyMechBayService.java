package com.clinkworks.mechwarrior.service;

import com.clinkworks.mechwarrior.data.MechData;
import com.clinkworks.mechwarrior.data.SmurfyMechData;
import com.clinkworks.mechwarrior.datatype.Loadout;
import com.clinkworks.mechwarrior.datatype.Mech;
import com.clinkworks.mechwarrior.datatype.Mechs;
import com.clinkworks.mechwarrior.domain.MechBay;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class SmurfyMechBayService implements MechBayService{
	
	private MechData mechData;
	
	@Inject
	public SmurfyMechBayService(SmurfyMechData mechData){
		this.mechData = mechData;
	}
	
	@Override
	public Mech getStockMech(int mechId) {
		Loadout loadout = mechData.getLoadoutForChassisId("stock", mechId);
		Mech mech = mechData.getChassisDetailsForSpecificChassisId(mechId);
		mech.setLoadout(loadout);
		return mech;
	}

	@Override
	public Mechs getAllMechs() {
		return mechData.getDetailsForAllChassis();
	}

	@Override
	public MechBay getMechBay() {
		return mechData.getMechBay();
	}



}
