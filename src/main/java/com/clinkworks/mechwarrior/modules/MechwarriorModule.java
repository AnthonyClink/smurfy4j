package com.clinkworks.mechwarrior.modules;

import com.google.inject.AbstractModule;

public class MechwarriorModule extends AbstractModule{

	@Override
	protected void configure() {
		install(new PropertiesModule());
		install(new MechDataModule());
		install(new JpaModule());
	}

}
