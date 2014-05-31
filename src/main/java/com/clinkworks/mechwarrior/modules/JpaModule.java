package com.clinkworks.mechwarrior.modules;

import com.clinkworks.mechwarrior.data.LocalMechData;
import com.clinkworks.mechwarrior.data.MechData;
import com.google.inject.AbstractModule;
import com.google.inject.persist.jpa.JpaPersistModule;

public class JpaModule extends AbstractModule{

	@Override
	protected void configure() {
		JpaPersistModule module = new JpaPersistModule("mechbay");
		install(module);
		bind(MechData.class).to(LocalMechData.class);
	}

}
