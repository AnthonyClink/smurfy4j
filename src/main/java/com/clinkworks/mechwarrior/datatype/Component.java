package com.clinkworks.mechwarrior.datatype;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Component {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int armor;
	private String name;
	
	@OneToMany(targetEntity = Item.class)
	private List<Item> items;

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
	
}
