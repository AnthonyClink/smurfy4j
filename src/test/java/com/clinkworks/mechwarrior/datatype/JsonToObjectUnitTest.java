package com.clinkworks.mechwarrior.datatype;

import static com.clinkworks.neptical.util.JsonUtil.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.clinkworks.mechwarrior.data.Mocks;
import com.clinkworks.mechwarrior.datatype.MechDetails.Stats;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonToObjectUnitTest {
	
	private JsonObject hunchback;
	private JsonObject hunchbackDetails;
	
	@Before
	public void setup(){
		hunchback = Mocks.hunchback4GStockLoadoutJson();
		hunchbackDetails = Mocks.hunchback4GChassis();
	}
	
	@Test
	public void ensureAMechCanBeObjectified(){
		Mech mech = toObject(Mech.class, hunchbackDetails);
		MechDetails mechDetails = mech.getMechDetails();
		assertFalse(mechDetails.ecmEnabled());
		assertEquals(3, mechDetails.getHardpoints().getEnergy());
	}
	
	@Test
	public void ensureAComponentCanBeObjectified(){
		JsonElement componentJson = getHunchbackHead();
		Component component = toObject(Component.class, componentJson);
		assertEquals("head", component.getName());
		assertEquals(18, component.getArmor());
	}
	
	@Test
	public void ensureLoadoutCanBeObjectified(){
		JsonElement loadoutJson = hunchback;
		Loadout loadout = toObject(Loadout.class, loadoutJson);
		assertEquals("STANDARD ARMOR", loadout.getUpgrades().get(0).getName());
	}
	
	@Test
	public void ensureStatsCanBeObjectified(){
		JsonElement statsJson = getHunchbackStats();
		Stats stats = toObject(Stats.class, statsJson);
		assertEquals(31, stats.getCoolingEfficiency());
		assertEquals(2, stats.getArmaments().get(2).getCount());
		assertEquals(5, stats.getEquipment().get(1).getCount());
		assertEquals(new BigDecimal("8.5"), stats.getDpsMax());
		assertEquals(new BigDecimal("2.635"), stats.getDpsSustained());
	}
	
	@Test
	public void ensureAnItemCanBeObjectified(){
		JsonElement itemJson = getHunchbacksHeadLaser();
		Item item = toObject(Item.class, itemJson);
		assertEquals("SMALL LASER", item.getName());
		assertEquals("weapon", item.getType());
	}
	
	public JsonObject getHunchbacksHeadLaser(){
		return getHunchbacksHeadItems().get(0).getAsJsonObject();
	}
	
	public JsonArray getHunchbacksHeadItems(){
		return getHunchbackHead().get("items").getAsJsonArray();
	}
	
	public JsonObject getHunchbackHead(){
		return getHunchbacksConfiguration().get(0).getAsJsonObject();
	}
	
	public JsonArray getHunchbacksConfiguration(){
		return hunchback.get("configuration").getAsJsonArray();
	}
	
	public JsonObject getHunchbackStats(){
		return hunchback.get("stats").getAsJsonObject();
	}
}
