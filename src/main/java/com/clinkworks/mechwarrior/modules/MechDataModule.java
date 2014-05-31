package com.clinkworks.mechwarrior.modules;

import com.clinkworks.mechwarrior.api.Smurfy;
import com.clinkworks.mechwarrior.data.LocalMechData;
import com.clinkworks.mechwarrior.data.MechData;
import com.clinkworks.mechwarrior.data.SmurfyMechData;
import com.clinkworks.mechwarrior.service.LocalMechBayService;
import com.clinkworks.mechwarrior.service.MechBayService;
import com.clinkworks.mechwarrior.service.SmurfyMechBayService;
import com.google.inject.AbstractModule;

public class MechDataModule extends AbstractModule{

	public static final String AUTHORIZATION_HEADER_NAME = "Authorization";

	public static class SmurfyDataModule extends AbstractModule{
		
		@Override
		protected void configure() {
			bind(MechData.class).annotatedWith(Smurfy.class).to(SmurfyMechData.class);
			bind(MechBayService.class).annotatedWith(Smurfy.class).to(SmurfyMechBayService.class);
			install(new SmurfyClientModule());
		}
	}
	
	@Override
	protected void configure() {
		bind(MechData.class).to(LocalMechData.class);
		bind(MechBayService.class).to(LocalMechBayService.class);
		install(new SmurfyDataModule());
	}
	


}
