package com.clinkworks.mechwarrior.data;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.clinkworks.mechwarrior.modules.MechDataModule.SmurfyDataModule;
import com.clinkworks.mechwarrior.modules.PropertiesModule;
import com.clinkworks.neptical.junit.runners.NepticalJUnit4Runner;
import com.clinkworks.neptical.junit.runners.NepticalJUnit4Runner.NepticalConfiguration;
import com.google.gson.JsonObject;

@RunWith(NepticalJUnit4Runner.class)
@NepticalConfiguration({PropertiesModule.class, SmurfyDataModule.class})
public class SmurfyMechDataIntegrationTest {
	
	@Test	
	public void ensureWeCanRetreieveAllMechDataFromSmurfy(SmurfyMechData mechData){
		JsonObject smurfyJson = mechData.getDetailsForAllChassisJson();
		assertTrue(smurfyJson.entrySet().size() > 0);
		assertTrue(smurfyJson.get("1").isJsonObject());
		assertEquals("hbk-4g", smurfyJson.get("1").getAsJsonObject().get("name").getAsString());
	}
	
	@Test
	public void ensureWeCanGetMechbayData(SmurfyMechData mechData){
		JsonObject mechBayJson = mechData.getMechbayJson();
		assertNotNull(mechBayJson.get("1"));
		assertNotNull(mechBayJson.get("1").getAsJsonObject().get("name").getAsString());
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
