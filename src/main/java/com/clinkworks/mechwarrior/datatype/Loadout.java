package com.clinkworks.mechwarrior.datatype;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Loadout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="clinkworksId")
	private String clinkworksId;
	
	@Column(name="smurfyId")
	private String id;
	
	@Column
	private int mech_id;
	
	@OneToMany
	private List<Component> configuration;
	
	@OneToMany
	private List<Item> upgrades;

	public String getClinkworksId() {
		return clinkworksId;
	}
	
	public void setClinkworksId(String clinkworksId) {
		this.clinkworksId = clinkworksId;
	}
	
	public String getSmurfyId(){
		return id;
	}
	
	//this is what you get for dual purposing a class
	//should have composed this long ago, but avoided it
	// will do it when I have more time
	public void setSmurfyId(String smurfyId){
		this.id = smurfyId;
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
