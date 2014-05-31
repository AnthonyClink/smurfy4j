package com.clinkworks.mechwarrior.datatype;

import java.util.List;

public class Loadout {
	
	private String id;
	private int mech_id;
	private List<Component> configuration;
	private List<Item> upgrades;

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getMechId() {
		return mech_id;
	}
	
	public void setMechId(int mech_id) {
		this.mech_id = mech_id;
	}
	
	public List<Component> getConfiguration() {
		return configuration;
	}
	
	public void setConfiguration(List<Component> configuration) {
		this.configuration = configuration;
	}
	
	public List<Item> getUpgrades(){
		return upgrades;
	}
	
	public void setUpgrades(List<Item> upgrades){
		this.upgrades = upgrades;
	}
}
