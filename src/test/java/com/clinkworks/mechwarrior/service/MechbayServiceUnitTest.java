package com.clinkworks.mechwarrior.service;

import static org.junit.Assert.*;
import mockit.Expectations;
import mockit.Mocked;

import org.junit.Before;
import org.junit.Test;

import com.clinkworks.mechwarrior.data.Mocks;
import com.clinkworks.mechwarrior.data.SmurfyMechData;
import com.clinkworks.mechwarrior.datatype.Loadout;
import com.clinkworks.mechwarrior.datatype.Mech;
import com.clinkworks.mechwarrior.domain.MechBay;

public class MechbayServiceUnitTest {
	
	private MechBayService mechbayService;
	
	@Mocked
	private SmurfyMechData mechData;
	
	@Before
	public void setup(){
		mechbayService = new SmurfyMechBayService(mechData);
	}
	
	@Test
	public void ensureServiceCanReturnAMechFromALoadoutSmurfyCall(){
		
		new Expectations(){{
			
			mechData.getLoadoutForChassisId(anyString, anyInt);
			result = new Loadout();
			times = 1;
			
			mechData.getChassisDetailsForSpecificChassisId(anyInt);
			result = new Mech();
			times = 1;
			
		}};
		
		mechbayService.getStockMech(1);
		
	}
	
	@Test
	public void ensureServiceCanReturnTheMechbay(){
		
		new Expectations(){{
			mechData.getMechBay();
			result = Mocks.emptyMechBay();
			times = 1;
		}};
		
		MechBay mechBay = mechbayService.getMechBay();
		
		assertEquals(0, mechBay.getTotalMechs());
	
	}
	
}
