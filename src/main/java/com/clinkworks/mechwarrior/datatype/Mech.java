package com.clinkworks.mechwarrior.datatype;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Mech {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private MechType mech_type;
	private String family;
	private String name;
	private String translated_name;
	private String translated_short_name;
	
	@Transient
	private MechDetails details;
	
	@OneToOne
	private Loadout loadout;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public MechType getMechType() {
		return mech_type;
	}
	
	public void setMechType(MechType mechType) {
		mech_type = mechType;
	}
	
	public String getFamily() {
		return family;
	}
	
	public void setFamily(String family) {
		this.family = family;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTranslatedName() {
		return translated_name;
	}
	
	public void setTranslatedName(String translatedName) {
		translated_name = translatedName;
	}
	
	public String getTranslatedShortName() {
		return translated_short_name;
	}
	
	public void setTranslatedShortName(String translatedShortName) {
		translated_short_name = translatedShortName;
	}
	
	public MechDetails getMechDetails() {
		return details;
	}
	
	public void setMechDetails(MechDetails mechDetails) {
		this.details = mechDetails;
	}

	public Loadout getLoadout() {
		return loadout;
	}

	public void setLoadout(Loadout loadout) {
		this.loadout = loadout;
	}
		
}
