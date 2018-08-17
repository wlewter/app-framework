package com.fbitn.appframework.repository;

import java.util.List;

import com.fbitn.appframework.model.Subsystem;

public interface SubsystemRepository {

	public List<Subsystem> getAll();
	public void insertOne(Subsystem subsystem);
	public Subsystem getOne(String name);
}
