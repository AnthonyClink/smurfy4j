package com.clinkworks.mechwarrior.datatype;

import java.math.BigDecimal;

import javax.persistence.Embedded;

public class MechDetails {
	
	private int mechId;
	private BigDecimal tons;
	private BigDecimal top_speed;
	private int jump_jets;
	private boolean ecm;
	private int module_slots;
	private EngineRange engine_range;
	private HardPoints hardpoints;
	private Stats stats;
	
	@Embedded
	private Price price;
	private int max_armor;
	

	
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
