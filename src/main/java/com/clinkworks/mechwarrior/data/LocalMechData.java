package com.clinkworks.mechwarrior.data;

import javax.persistence.EntityManager;

import com.clinkworks.mechwarrior.datatype.Component;
import com.clinkworks.mechwarrior.datatype.Item;
import com.clinkworks.mechwarrior.datatype.Loadout;
import com.clinkworks.mechwarrior.datatype.Mech;
import com.clinkworks.mechwarrior.datatype.Mechs;
import com.clinkworks.mechwarrior.domain.MechBay;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class LocalMechData implements MechData{

	private final Provider<EntityManager> entityManagerProvider;
	
	@Inject
	public LocalMechData(Provider<EntityManager> entityManagerProvider){
		this.entityManagerProvider = entityManagerProvider;
	}
	
	public void saveItem(Item item){
		EntityManager entityManager = entityManagerProvider.get();
		entityManager.persist(item);
		entityManager.merge(item);
	}
	
	public void saveComponent(Component component){
		EntityManager entityManager = entityManagerProvider.get();
		for(Item item : component.getItems()){
			saveItem(item);
		}
		entityManager.merge(component);
	}
	     
	@Override
	public Mechs getDetailsForAllChassis() {
		return null;
	}

	@Override
	public Mech getChassisDetailsForSpecificChassisId(int id) {
		return null;
	}

	@Override
	public Loadout getLoadoutForChassisId(String loadoutId, int chassisId) {
		return null;
	}


	@Override
	public MechBay getMechBay() {
		return null;
	}


}
