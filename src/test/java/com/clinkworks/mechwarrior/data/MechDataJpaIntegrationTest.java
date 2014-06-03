package com.clinkworks.mechwarrior.data;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.clinkworks.mechwarrior.datatype.Mech;
import com.clinkworks.mechwarrior.modules.MechwarriorModule;
import com.clinkworks.mechwarrior.service.LocalMechBayService;
import com.clinkworks.neptical.junit.runners.NepticalJUnit4Runner;
import com.clinkworks.neptical.junit.runners.NepticalJUnit4Runner.NepticalConfiguration;
import com.google.inject.persist.PersistService;

@RunWith(NepticalJUnit4Runner.class)
@NepticalConfiguration({MechwarriorModule.class})
public class MechDataJpaIntegrationTest {
	
	@Before
	public void setup(PersistService persistService){
		persistService.start();
	}
	
	@Test
	public void canCommitAComponentWithOneItem(LocalMechBayService mechBayService){
		mechBayService.saveComponent(Mocks.getHeadComponentWithSmallLaser());
	}
	
	@Test
	public void canCommitAnItem(LocalMechBayService mechBayService){
		mechBayService.saveItem(Mocks.getSmallLaserItem());
	}
	
	@Test
	public void canCommitAMech(LocalMechBayService localMechBayService){
		Mech mech = Mocks.hunchback4GStockLoadoutMech();
		localMechBayService.saveMech(mech);
	}

}
