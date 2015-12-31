package com.adrian.ServiceLocator;

import java.util.ArrayList;
import java.util.List;

public class Cache {

	private List<Service> services;

	public Cache() {
		services = new ArrayList<Service>();
	}

	public Service getService(String serviceName){
		for (Service service : services) {
			if (service.getName().equalsIgnoreCase(serviceName)) {
				System.out.println("Returning cached "+serviceName+" Object");
				return service;
			}
		}
		return null;
	}
	
	public void addService(Service newService){
		boolean exists = false;
		for (Service service : services) {
			if (service.getName().equals(newService.getName())) {
				exists = true;
			}
		}
		if (!exists) {
			services.add(newService);
		}
	}

}
