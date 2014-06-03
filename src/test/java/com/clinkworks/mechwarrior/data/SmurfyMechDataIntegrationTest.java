package com.clinkworks.mechwarrior.data;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.clinkworks.mechwarrior.modules.MechwarriorModule;
import com.clinkworks.neptical.junit.runners.NepticalJUnit4Runner;
import com.clinkworks.neptical.junit.runners.NepticalJUnit4Runner.NepticalConfiguration;
import com.google.gson.JsonObject;

@RunWith(NepticalJUnit4Runner.class)
@NepticalConfiguration({MechwarriorModule.class})
public class SmurfyMechDataIntegrationTest {
		
	@Test
	public void canRetrieveClinkworksUserNameFromSmurfy(SmurfyMechData mechData){
		assertEquals("clinkworks", mechData.getSmurfyUserName(mechData.getDefaultApiKey()));
	}
	
	@Test	
	public void ensureWeCanRetreieveAllMechDataFromSmurfy(SmurfyMechData mechData){
		JsonObject smurfyJson = mechData.getDetailsForAllChassisJson();
		assertTrue(smurfyJson.entrySet().size() > 0);
		assertTrue(smurfyJson.get("1").isJsonObject());
		assertEquals("hbk-4g", smurfyJson.get("1").getAsJsonObject().get("name").getAsString());
	}
	
	@Test
	public void ensureWeCanGetMechbayData(SmurfyMechData mechData){
		//TODO: report api inconsistancy to smurfy. This method returns an empty array when theres no results.
		//but returns an object thats "arraylike". 
		//some best practice research will need to be done.
		JsonObject mechBayJson = mechData.getMechbayJson(mechData.getDefaultApiKey());
		assertNotNull(mechBayJson);
	}
	
	@Test
	public void ensureWeCanRetrieveLoadoutInformationFromSmurfy(SmurfyMechData mechData){
		JsonObject hunchbackFourG = mechData.getLoadoutForChassisIdJson("stock", 1);
		assertEquals(1, hunchbackFourG.get("mech_id").getAsInt());
		assertEquals("stock", hunchbackFourG.get("id").getAsString());
	}
	
	@Test
	public void ensureWeCanRetrieveSpecificMechDataFromSmurfy(SmurfyMechData mechData){
		JsonObject hunchbackFourG = mechData.getChassisDetailsForSpecificChassisIdJson(1);
		assertEquals("hbk-4g", hunchbackFourG.get("name").getAsString());
	}
	
	
}
