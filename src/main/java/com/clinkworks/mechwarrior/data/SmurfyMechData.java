package com.clinkworks.mechwarrior.data;

import static com.clinkworks.neptical.util.JsonUtil.*;

import java.io.Serializable;
import java.net.URI;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.ws.rs.HttpMethod;

import com.clinkworks.mechwarrior.datatype.Loadout;
import com.clinkworks.mechwarrior.datatype.Mech;
import com.clinkworks.mechwarrior.datatype.Mechs;
import com.clinkworks.mechwarrior.domain.MechBay;
import com.clinkworks.mechwarrior.exception.ApiConversionException;
import com.clinkworks.mechwarrior.modules.MechDataModule;
import com.clinkworks.neptical.util.JsonUtil;
import com.google.common.collect.Maps;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientRequest;

@Singleton
public class SmurfyMechData implements MechData {
	
	private final URI SMURFY_GET_ALL_CHASSIS_GENERIC = URI.create("http://mwo.smurfy-net.de/api/data/mechs.json");
	private final URI SMURFY_GET_MECHBAY_URI = URI.create("https://mwo.smurfy-net.de/api/data/user/mechbay.json");
	
	private final String SMURFY_GET_SPECIFIC_CHASSIS_URI_TEMPLATE = "http://mwo.smurfy-net.de/api/data/mechs/%s.json";
	private final String SMURFY_GET_LOADOUT_URI_TEMPLATE = "http://mwo.smurfy-net.de/api/data/mechs/%s/loadouts/%s.json";
	
	private final Client jerseyClient;
	private final String apiKey;
	
	@Inject
	public SmurfyMechData(Client jerseyClient, @Named("smurfy.access.token") String apiKey){
		this.jerseyClient = jerseyClient;
		this.apiKey = apiKey;
	}

	/* (non-Javadoc)
	 * @see com.clinkworks.mechwarrior.data.MechData#getDetailsForAllChassis()
	 */
	@Override
	public Mechs getDetailsForAllChassis() {
			
		Map<Integer, Mech> mechIndex = Maps.newHashMap();
		Mechs mechs = new Mechs();
		mechs.setMechs(mechIndex);
		
		JsonObject mechJson = getDetailsForAllChassisJson();
		
		for(Map.Entry<String, JsonElement> entry : mechJson.entrySet()) {
			
			try{
				
				Mech mech = toObject(Mech.class, entry.getValue());
				
				mechIndex.put(mech.getId(), mech);
				
			}catch(JsonSyntaxException e){
				throw new ApiConversionException("Failed at id: " + entry.getKey() + " (GSON error:"+ e.getMessage() + ")", e);
			}
			
		}		
		
		return mechs;
	}		
		
	

	/* (non-Javadoc)
	 * @see com.clinkworks.mechwarrior.data.MechData#getChassisDetailsForSpecificChassisId(int)
	 */
	@Override
	public Mech getChassisDetailsForSpecificChassisId(int id) {
		return handle(smurfyGet(specificChassisUri(id)), Mech.class);
	}
	
	/* (non-Javadoc)
	 * @see com.clinkworks.mechwarrior.data.MechData#getLoadoutForChassisId(java.lang.String, int)
	 */
	@Override
	public Loadout getLoadoutForChassisId(String loadoutId, int chassisId){
		return handle(smurfyGet(loadoutForIdUri(chassisId, loadoutId)), Loadout.class);
	}
	
	/* (non-Javadoc)
	 * @see com.clinkworks.mechwarrior.data.MechData#getMechbay()
	 */
	@Override
	public MechBay getMechBay(){
		
		Map<Serializable, Mech> mechs = Maps.newHashMap();
		MechBay mechBay = new MechBay(mechs);
		JsonObject mechJson = getMechbayJson();
		
		for(Map.Entry<String, JsonElement> entry : mechJson.entrySet()) {
			
			try{
				
				JsonObject loadoutData = entry.getValue().getAsJsonObject().get("loadout").getAsJsonObject();
				JsonObject chassisData = getChassisDetailsForSpecificChassisIdJson(loadoutData.get("mech_id").getAsInt());
				
				Mech mech = toObject(Mech.class, chassisData);
				mech.setName(entry.getValue().getAsJsonObject().get("name").getAsString());
				mech.setLoadout(toObject(Loadout.class, loadoutData));
				
				mechs.put(loadoutData.get("id").getAsString(), mech);
				
			}catch(JsonSyntaxException e){
				throw new ApiConversionException("Failed at id: " + entry.getKey() + " (GSON error:"+ e.getMessage() + ")", e);
			}
			
		}		
		
		return mechBay;
	}

	public JsonObject getDetailsForAllChassisJson() {
		return handle(smurfyGet(smurfyGetAllURI()), JsonObject.class);
	}

	public JsonObject getChassisDetailsForSpecificChassisIdJson(int id) {
		return handle(smurfyGet(specificChassisUri(id)), JsonObject.class);
	}
	
	public JsonObject getLoadoutForChassisIdJson(String loadoutId, int chassisId){
		return handle(smurfyGet(loadoutForIdUri(chassisId, loadoutId)), JsonObject.class);
	}
	
	public JsonObject getMechbayJson(){
		return handle(smurfyGet(mechbayURI()), JsonObject.class);
	}
		
	private URI smurfyGetAllURI(){
		return SMURFY_GET_ALL_CHASSIS_GENERIC;
	}
	
	private URI specificChassisUri(int id){
		return URI.create(
					String.format(SMURFY_GET_SPECIFIC_CHASSIS_URI_TEMPLATE, id)
				);
	}
	
	private URI loadoutForIdUri(int mechId, String loadoutId){
		return URI.create(
				String.format(SMURFY_GET_LOADOUT_URI_TEMPLATE, mechId, loadoutId)
			);
	}
	
	private URI mechbayURI(){
		return SMURFY_GET_MECHBAY_URI;
	}
	
	private ClientRequest smurfyGet(URI uri){
		return ClientRequest.create().
				header(MechDataModule.AUTHORIZATION_HEADER_NAME, apiKey).
				build(uri, HttpMethod.GET);		
	}
	
	private <T> T handle(ClientRequest clientRequest, Class<T> type){
		String rawJson = jerseyClient.handle(clientRequest).getEntity(String.class);
		return JsonUtil.toObject(type, rawJson);	
	}


}
