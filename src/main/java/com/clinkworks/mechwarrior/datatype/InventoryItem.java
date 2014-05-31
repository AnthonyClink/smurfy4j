package com.clinkworks.mechwarrior.datatype;

public class InventoryItem {
	
	private Item item;
	private int count;
	
	public InventoryItem(){
		item = new Item();
	}

	public void setCount(int count){
		this.count = count;
	}
	
	public int getCount(){
		return count;
	}
	
	public Item getItem(){
		return item;
	}
	
	public String getName() {
		return getItem().getName();
	}

	public String getType() {
		return getItem().getType();
	}

	public void setType(String itemType) {
		getItem().setType(itemType);
	}

	public void setName(String name) {
		getItem().setName(name);
	}

	public int getId() {
		return getItem().getId();
	}

	public void setId(int id) {
		getItem().setId(id);
	}
	
}
