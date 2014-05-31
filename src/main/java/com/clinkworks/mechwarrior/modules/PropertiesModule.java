package com.clinkworks.mechwarrior.modules;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.inject.Singleton;

import com.google.inject.AbstractModule;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class PropertiesModule extends AbstractModule{
	
	private final Properties mechwarriorProperies;

	public PropertiesModule(){
		File mechwarriorPropsFile = new File(Thread.currentThread().getContextClassLoader().getResource("mechwarrior.properties").getFile().replace("%20", " "));
		
		FileReader fileReader = null;
		
		try {
			fileReader = new FileReader(mechwarriorPropsFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties properties = new Properties();
		try {
			properties.load(fileReader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mechwarriorProperies = properties;		
	}
	
	@Override
	protected void configure() {
		Names.bindProperties(binder(), mechwarriorProperies);
	}
	
	
	@Singleton
	@Named("mechwarrior.properties")
	public Properties getMechwarriorProperties(){
		return mechwarriorProperies;
	}
	
}
