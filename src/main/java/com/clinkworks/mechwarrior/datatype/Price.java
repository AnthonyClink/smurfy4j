package com.clinkworks.mechwarrior.datatype;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Price{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String loadout_id;
	
	private int mc;
	
	private int cb;
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setMc(int mc){
		this.mc = mc;
	}
	
	public int getMc(){
		return mc;
	}
	
	public void setCb(int cb){
		this.cb = cb;
	}
	
	public int getCb(){
		return cb;
	}

	public String getLoadout_id() {
		return loadout_id;
	}

	public void setLoadout_id(String loadout_id) {
		this.loadout_id = loadout_id;
	}
}