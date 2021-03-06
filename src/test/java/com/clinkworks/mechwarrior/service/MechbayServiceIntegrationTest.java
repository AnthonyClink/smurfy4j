package com.clinkworks.mechwarrior.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.clinkworks.mechwarrior.api.Smurfy;
import com.clinkworks.mechwarrior.datatype.Mech;
import com.clinkworks.mechwarrior.datatype.Mechs;
import com.clinkworks.mechwarrior.domain.MechBay;
import com.clinkworks.mechwarrior.modules.MechwarriorModule;
import com.clinkworks.neptical.junit.runners.NepticalJUnit4Runner;
import com.clinkworks.neptical.junit.runners.NepticalJUnit4Runner.NepticalConfiguration;
import com.google.inject.Inject;
import com.google.inject.name.Named;

@RunWith(NepticalJUnit4Runner.class)
@NepticalConfiguration({MechwarriorModule.class})
public class MechbayServiceIntegrationTest {
	
	@Inject
	@Smurfy
	private MechBayService mechBayService;
	
	@Test
	public void ensureMechbayServiceProperlyRetrievesTheMechbay(@Named("test.api.key.with.mechbay") String apiKey){
		MechBay mechBay = mechBayService.getMechBay(apiKey);
		Mech mech = mechBay.getMech("6cbdc2116a661de7ae0eec9ffb54e5e363ad1f93");
		assertEquals("Ole-Trusty", mech.getName());
	}
	
	@Test
	public void ensureMechbayServiceProperlyRetrivesASingleStockMech(){
			Mech mech = mechBayService.getStockMech(1);
			assertEquals("hbk-4g", mech.getName());
	}	
	
	@Test
	public void ensureMechbayServiceProperlyRetrievesAllMechs(){
		Mechs allMechs = mechBayService.getAllMechs();
		assertEquals("hbk-4g", allMechs.getMechs().get(1).getName());
	}
}
