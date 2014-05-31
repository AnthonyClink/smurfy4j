package com.clinkworks.mechwarrior.domain;

import com.clinkworks.mechwarrior.datatype.Mech;

public class UserMech {
	
	private Object user;
	private Mech mechData;
	
	public UserMech(Object user, Mech mechData){
		this.mechData = mechData;
		this.user = user;
	}
}
