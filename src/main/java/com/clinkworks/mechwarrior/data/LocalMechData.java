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
		saveOrMerge(item);
		entityManagerProvider.get().flush();
	}
	
	public void saveComponent(Component component){
		EntityManager entityManager = entityManagerProvider.get();
		
		for(Item item : component.getItems()){
			saveOrMerge(item);
		}
		
		saveOrMerge(component);
		entityManager.flush();
	}
	    
	public void saveLoadout(Loadout loadout){
		
		for(Component component : loadout.getConfiguration()){
			component.setLoadoutId(loadout.getSmurfyId());
			saveComponent(component);
		}
		
		for(Item upgrade : loadout.getUpgrades()){
			saveItem(upgrade);
		}
		
		saveOrMerge(loadout);
	}
	
	private void saveOrMerge(Loadout loadout){
		EntityManager entityManager = entityManagerProvider.get();
		
		if(entityManager.contains(loadout)){
			return;
		}
		
		if(loadout.getClinkworksId() == null){
			entityManager.persist(loadout);
			entityManager.merge(loadout);
			entityManager.flush();
		}
		
		
		if(!entityManager.contains(loadout)){
			entityManager.merge(loadout);
		}		
	}
	
	public void saveMech(Mech mech) {
		EntityManager entityManager = entityManagerProvider.get();
		Loadout loadout = mech.getLoadout();
		loadout.setMechId(mech.getId());
		saveLoadout(loadout);
		saveOrMerge(mech);
		entityManager.flush();
	}
	
	private void saveOrMerge(Mech mech) {
		EntityManager entityManager = entityManagerProvider.get();
		
		if(entityManager.contains(mech)){
			return;
		}
		
		Mech foundMech = entityManager.find(Mech.class, mech.getId());
		
		if(foundMech == null){
			entityManager.merge(foundMech);
		}
		
		if(!entityManager.contains(mech)){
			entityManager.merge(mech);
		}		
		
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
	public MechBay getMechBay(String smurfyApiKey) {
		return null;
	}

	private void saveOrMerge(Item item){
		EntityManager entityManager = entityManagerProvider.get();
		
		if(entityManager.contains(item)){
			return;
		}
		
		Item foundItem = entityManager.find(Item.class, item.getId());
		
		if(foundItem == null){
			entityManager.persist(item);
			entityManager.merge(item);
		}
		
		if(!entityManager.contains(foundItem)){
			entityManager.merge(item);
		}else{
			entityManager.flush();
		}
		
	}
	
	public void saveOrMerge(Component component){
		
		EntityManager entityManager = entityManagerProvider.get();
		
		if(entityManager.contains(component)){
			return;
		}
		
		Component foundComponent = entityManager.find(Component.class, component.getId());
		
		if(foundComponent == null){
			entityManager.persist(component);
			entityManager.merge(component);
			foundComponent = component;
		}
		
		if(!entityManager.contains(component)){
			entityManager.merge(component);
		}
		
	}
}
