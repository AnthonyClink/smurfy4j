package com.clinkworks.mechwarrior.datatype;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Component {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(targetEntity=Loadout.class)
	private String loadout_id;
	
	private int armor;
	private String name;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	private List<Item> items;

	public int getId() {
		return id;
	}	
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setArmor(int armor){
		this.armor = armor;
	}
	
	public int getArmor() {
		return armor;
	}
	
	public void setItems(List<Item> items){
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	public String getLoadoutId() {
		return loadout_id;
	}

	public void setLoadoutId(String loadout_id) {
		this.loadout_id = loadout_id;
	}
	
}
