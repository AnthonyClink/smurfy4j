package com.clinkworks.mechwarrior.service;

import com.clinkworks.mechwarrior.datatype.Mech;
import com.clinkworks.mechwarrior.datatype.Mechs;
import com.clinkworks.mechwarrior.domain.MechBay;

public interface MechBayService {

	public abstract Mech getStockMech(int mechId);

	public abstract Mechs getAllMechs();

	public abstract MechBay getMechBay();

}