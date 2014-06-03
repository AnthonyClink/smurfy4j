package com.clinkworks.mechwarrior.data;

import com.clinkworks.mechwarrior.datatype.Loadout;
import com.clinkworks.mechwarrior.datatype.Mech;
import com.clinkworks.mechwarrior.datatype.Mechs;
import com.clinkworks.mechwarrior.domain.MechBay;

public interface MechData {

	public abstract Mechs getDetailsForAllChassis();

	public abstract Mech getChassisDetailsForSpecificChassisId(int id);

	public abstract Loadout getLoadoutForChassisId(String loadoutId,
			int chassisId);
	
	public abstract MechBay getMechBay(String smurfyApiKey);

}