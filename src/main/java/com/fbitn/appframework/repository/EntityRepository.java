package com.fbitn.appframework.repository;

import java.util.List;

import com.fbitn.appframework.model.entity.Entity;

public interface EntityRepository {

	public List<Entity> getAll();
	public Entity getOne(String name);
	public void insertOne(Entity entity);
}
