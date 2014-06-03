package com.clinkworks.mechwarrior.domain;

import java.io.Serializable;
import java.util.Map;

import com.clinkworks.mechwarrior.datatype.Mech;
import com.google.inject.Inject;

public class MechBay {
	
	private Map<Serializable, Mech> mechs;

	@Inject
	public MechBay(Map<Serializable, Mech> mechs){
		this.mechs = mechs;
	}

	public int getTotalMechs() {
		return mechs.keySet().size();
	}
	
	public Mech getMech(String mechbayId){
		return mechs.get(mechbayId);
	}

	
	
}
