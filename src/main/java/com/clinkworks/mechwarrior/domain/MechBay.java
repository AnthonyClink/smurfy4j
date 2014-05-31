package com.clinkworks.mechwarrior.domain;

import java.io.Serializable;
import java.util.Map;

import com.clinkworks.mechwarrior.datatype.Mech;

public class MechBay {
	
	private Map<Serializable, Mech> mechs;

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
