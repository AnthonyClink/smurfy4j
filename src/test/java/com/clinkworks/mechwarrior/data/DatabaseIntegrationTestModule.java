package com.clinkworks.mechwarrior.data;

import com.clinkworks.mechwarrior.modules.JpaModule;
import com.google.inject.AbstractModule;

public class DatabaseIntegrationTestModule extends AbstractModule{
	
	@Override
	protected void configure() {
		install(new JpaModule());
	}
	
}
