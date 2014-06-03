package com.clinkworks.mechwarrior.service;

import com.clinkworks.mechwarrior.datatype.Mech;
import com.clinkworks.mechwarrior.datatype.Mechs;
import com.clinkworks.mechwarrior.domain.MechBay;
import com.clinkworks.mechwarrior.domain.User;

public interface MechBayService {

	public abstract Mech getStockMech(int mechId);

	public abstract Mechs getAllMechs();

	public abstract MechBay getMechBay(String apiKey);
	
	public abstract MechBay getMechBay(User user);

	public abstract Mech getMechWithSpecificLoadout(int mechId, String loadoutId);

}