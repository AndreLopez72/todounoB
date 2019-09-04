package com.todouno.hulkstore.infraestructure.entrypoint.controller;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class JAXRSConfiguration extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();
	
	public JAXRSConfiguration() {
	  singletons.add(new ProductoController());
	}
	
	@Override
	public Set<Object> getSingletons(){
		return singletons;
	}

}
