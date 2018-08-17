package com.fbitn.appframework.repository;

import java.util.ArrayList;
import java.util.List;

import com.fbitn.appframework.model.Subsystem;

public class SubsystemMemoryRepo implements SubsystemRepository {

	private List<Subsystem> systems;
	
	public SubsystemMemoryRepo() {
		systems = new ArrayList<>();
	}
	
	@Override
	public List<Subsystem> getAll() {
		return systems;
	}

	@Override
	public void insertOne(Subsystem subsystem) {
		systems.add(subsystem);
	}

	@Override
	public Subsystem getOne(String name) {
		return systems.stream().filter(e -> e.getName().equalsIgnoreCase(name)).findFirst().get();
	}
}
