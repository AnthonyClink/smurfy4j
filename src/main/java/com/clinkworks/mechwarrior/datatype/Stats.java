package com.clinkworks.mechwarrior.datatype;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stats{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int mechId;
	
	private String loadoutId;
	
	private int used_armor;
	private int used_jump_jets;
	private BigDecimal firepower;
	private BigDecimal dps_max;
	private BigDecimal dps_sustained;
	private int cooling_efficiency;
	private int heatsinks;
	private BigDecimal top_speed;
	private BigDecimal top_speed_tweak;
	private String engine_name;
	private int engine_rating;
	private EngineType engine_type;
	private List<InventoryItem> armaments;
	private List<InventoryItem> ammunition;
	private List<InventoryItem> equipment;
	
	public int getUsedArmor() {
		return used_armor;
	}
	
	public void setUsedArmor(int usedArmor) {
		this.used_armor = usedArmor;
	}
	
	public int getUsedJumpJets() {
		return used_jump_jets;
	}
	
	public void setUsedJumpJets(int usedJumpJets) {
		this.used_jump_jets = usedJumpJets;
	}
	
	public BigDecimal getFirepower() {
		return firepower;
	}
	
	public void setFirepower(BigDecimal firepower) {
		this.firepower = firepower;
	}
	
	public BigDecimal getDpsMax() {
		return dps_max;
	}
	
	public void setDpsMax(BigDecimal dpsMax) {
		this.dps_max = dpsMax;
	}
	
	public BigDecimal getDpsSustained() {
		return dps_sustained;
	}
	
	public void setDpsSustained(BigDecimal dpsSustained) {
		this.dps_sustained = dpsSustained;
	}
	
	public int getCoolingEfficiency() {
		return cooling_efficiency;
	}
	
	public void setCoolingEfficiency(int coolingEfficiency) {
		this.cooling_efficiency = coolingEfficiency;
	}
	
	public int getHeatsinks() {
		return heatsinks;
	}
	
	public void setHeatsinks(int heatsinks) {
		this.heatsinks = heatsinks;
	}
	
	public BigDecimal getTopSpeed() {
		return top_speed;
	}
	
	public void setTopSpeed(BigDecimal topSpeed) {
		this.top_speed = topSpeed;
	}
	
	public BigDecimal getTopSpeedTweak() {
		return top_speed_tweak;
	}
	
	public void setTopSpeedTweak(BigDecimal topSpeedTweak) {
		this.top_speed_tweak = topSpeedTweak;
	}
	
	public String getEngineName() {
		return engine_name;
	}
	
	public void setEngineName(String engineName) {
		this.engine_name = engineName;
	}
	
	public int getEngineRating() {
		return engine_rating;
	}
	
	public void setEngineRating(int engineRating) {
		this.engine_rating = engineRating;
	}
	
	public EngineType getEngineType() {
		return engine_type;
	}
	
	public void setEngineType(EngineType engineType) {
		this.engine_type = engineType;
	}
	
	public List<InventoryItem> getArmaments() {
		return armaments;
	}
	
	public void setArmaments(List<InventoryItem> armaments) {
		this.armaments = armaments;
	}
	
	public List<InventoryItem> getAmmunition() {
		return ammunition;
	}
	
	public void setAmmunition(List<InventoryItem> ammunition) {
		this.ammunition = ammunition;
	}
	
	public List<InventoryItem> getEquipment() {
		return equipment;
	}
	
	public void setEquipment(List<InventoryItem> equipment) {
		this.equipment = equipment;
	}

	public int getMechId() {
		return mechId;
	}

	public void setMechId(int mechId) {
		this.mechId = mechId;
	}

	public String getLoadoutId() {
		return loadoutId;
	}

	public void setLoadoutId(String loadoutId) {
		this.loadoutId = loadoutId;
	}
	
}