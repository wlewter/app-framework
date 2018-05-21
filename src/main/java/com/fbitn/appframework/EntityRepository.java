package com.fbitn.appframework;

import java.util.List;

public interface EntityRepository {

	public List<Entity> getAll();
	public Entity getOne(String name);
	public void insertOne(Entity entity);
}
