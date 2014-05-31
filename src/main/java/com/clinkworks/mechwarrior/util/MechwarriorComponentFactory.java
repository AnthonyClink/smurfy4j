package com.clinkworks.mechwarrior.util;

import java.util.Map;

import com.clinkworks.mechwarrior.datatype.Mech;
import com.clinkworks.mechwarrior.domain.MechBay;

public interface MechwarriorComponentFactory {
	public MechBay createMechBay(Map<Integer, Mech> mechs);
}
