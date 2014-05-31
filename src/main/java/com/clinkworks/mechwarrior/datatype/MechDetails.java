package com.clinkworks.mechwarrior.datatype;

import java.math.BigDecimal;
import java.util.List;

public class MechDetails {
	
	private BigDecimal tons;
	private BigDecimal top_speed;
	private int jump_jets;
	private boolean ecm;
	private int module_slots;
	private EngineRange engine_range;
	private HardPoints hardpoints;
	private Stats stats;
	private Price price;
	private int max_armor;
	
	public static class Stats{
		
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
		
	}
	
	public static class Price{
		
		private int id;
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
	}
	
	public static class HardPoints{
		
		private int ams;
		private int beam;
		private int ballistic;
		private int missile;
		private int ecm;
		
		public int getAms() {
			return ams;
		}
		
		public void setAms(int count) {
			ams = count;
		}
		
		public int getEnergy() {
			return beam;
		}
		
		public void setEnergy(int count) {
			beam = count;
		}
		
		public int getBallistic() {
			return ballistic;
		}
		
		public void setBallistic(int count) {
			ballistic = count;
		}
		
		public int getMissile() {
			return missile;
		}
		
		public void setMissile(int missile) {
			this.missile = missile;
		}
		
		public int getEcm() {
			return ecm;
		}
		
		public void setEcm(int ecm) {
			this.ecm = ecm;
		}
	}
	
	public static class EngineRange{

		private int min;
		private int max;
		
		public int getMin(){
			return min;
		}
		
		public void setMin(int min){
			this.min = min;
		}
		
		public int getMax(){
			return max;
		}
		
		public void setMax(int max){
			this.max = max;
		}
	}

	public BigDecimal getTons() {
		return tons;
	}

	public BigDecimal getTopSpeed() {
		return top_speed;
	}

	public boolean jumpJetsEnabled() {
		return getMaxJumpJets() > 0;
	}

	public boolean ecmEnabled() {
		return ecm;
	}

	public int getModuleSlots() {
		return module_slots;
	}

	public EngineRange getEngineRange() {
		return engine_range;
	}

	public HardPoints getHardPoints() {
		return getHardpoints();
	}

	public Price getPrice() {
		return price;
	}

	public int getMaxArmor() {
		return max_armor;
	}

	public void setTons(BigDecimal tons) {
		this.tons = tons;
	}

	public void setTopSpeed(BigDecimal top_speed) {
		this.top_speed = top_speed;
	}

	public void setEcmEnabled(boolean ecm) {
		this.ecm = ecm;
	}

	public void setModuleSlots(int module_slots) {
		this.module_slots = module_slots;
	}

	public void setEngineRange(EngineRange engine_range) {
		this.engine_range = engine_range;
	}

	public HardPoints getHardpoints() {
		return hardpoints;
	}

	public void setHardpoints(HardPoints hardpoints) {
		this.hardpoints = hardpoints;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public void setMaxArmor(int max_armor) {
		this.max_armor = max_armor;
	}
	
	public void setStats(Stats stats){
		this.stats = stats;
	}
	
	public Stats getStats(){
		return stats;
	}

	public int getMaxJumpJets() {
		return jump_jets;
	}

	public void setMaxJumpJets(int jumpJets) {
		jump_jets = jumpJets;
	}
	
}
