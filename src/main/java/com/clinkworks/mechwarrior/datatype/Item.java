package com.clinkworks.mechwarrior.datatype;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="Items")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clinkworksId;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String type;

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public void setType(String itemType) {
		this.type = itemType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
