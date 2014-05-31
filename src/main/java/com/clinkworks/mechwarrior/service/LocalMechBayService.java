package com.clinkworks.mechwarrior.service;

import javax.persistence.EntityManager;

import com.clinkworks.mechwarrior.data.LocalMechData;
import com.clinkworks.mechwarrior.data.SmurfyMechData;
import com.clinkworks.mechwarrior.datatype.Component;
import com.clinkworks.mechwarrior.datatype.Item;
import com.clinkworks.mechwarrior.datatype.Loadout;
import com.clinkworks.mechwarrior.datatype.Mech;
import com.clinkworks.mechwarrior.datatype.Mechs;
import com.clinkworks.mechwarrior.domain.MechBay;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

@Singleton
public class LocalMechBayService implements MechBayService {
	
	private final LocalMechData localMechData;
	private final SmurfyMechData smurfyMechData;
	
	@Inject
	public LocalMechBayService(SmurfyMechData smurfyData, LocalMechData localMechData, Provider<EntityManager> entityManagerProvider){
		this.localMechData = localMechData;
		this.smurfyMechData = smurfyData;
	}
	
	@Transactional
	public void saveItem(Item item){
		localMechData.saveItem(item);
	}
	
	@Transactional
	public void saveComponent(Component component) {
		localMechData.saveComponent(component);
	}
	
	/* (non-Javadoc)
	 * @see com.clinkworks.mechwarrior.service.MechBayService#getStockMech(int)
	 */
	@Override
	public Mech getStockMech(int mechId){
		Loadout loadout = smurfyMechData.getLoadoutForChassisId("stock", mechId);
		Mech mech = smurfyMechData.getChassisDetailsForSpecificChassisId(mechId);
		mech.setLoadout(loadout);
		return mech;
	}
	
	/* (non-Javadoc)
	 * @see com.clinkworks.mechwarrior.service.MechBayService#getAllMechs()
	 */
	@Override
	public Mechs getAllMechs(){
		return smurfyMechData.getDetailsForAllChassis();
	}
	
	/* (non-Javadoc)
	 * @see com.clinkworks.mechwarrior.service.MechBayService#getMechBay()
	 */
	@Override
	public MechBay getMechBay(){
		return smurfyMechData.getMechBay();
	}
	
}
