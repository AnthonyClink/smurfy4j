package com.clinkworks.mechwarrior.modules;

import java.io.Serializable;
import java.util.Map;

import com.clinkworks.mechwarrior.datatype.Mech;
import com.clinkworks.mechwarrior.util.MechwarriorComponentFactory;
import com.google.common.collect.Maps;
import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class MechwarriorModule extends AbstractModule{

	@Override
	protected void configure() {		
		install(configureMCF());
		install(new PropertiesModule());
		install(new MechDataModule());
		install(new JpaModule());
	}

	private Module configureMCF() {
		FactoryModuleBuilder factoryModuleBuilder = new FactoryModuleBuilder();
		Module mechwarriorComponentFactoryModule = factoryModuleBuilder.build(MechwarriorComponentFactory.class);
		return mechwarriorComponentFactoryModule;
	}
	
	@Provides
	public Map<Serializable, Mech> mechMap(){
		return Maps.newHashMap();
	}

}
