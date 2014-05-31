package com.clinkworks.mechwarrior.datatype;

import java.util.Map;

public class Mechs {
	
	private Map<Integer, Mech> mechs;

	public Map<Integer, Mech> getMechs() {
		return mechs;
	}

	public void setMechs(Map<Integer, Mech> mechMap) {
		this.mechs = mechMap;
	}

}
