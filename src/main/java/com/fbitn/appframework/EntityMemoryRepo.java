package com.fbitn.appframework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EntityMemoryRepo implements EntityRepository {

	private List<Entity> fields;
	
	public EntityMemoryRepo() {
		fields = new ArrayList<>();
	}
	
	@Override
	public List<Entity> getAll() {
		fields.sort(Comparator.comparingInt(Entity::getOrder));
		return fields;
	}

	@Override
	public Entity getOne(String name) {
		return fields.stream().filter(e -> e.getName().equalsIgnoreCase(name)).findFirst().get();
	}

	@Override
	public void insertOne(Entity entity) {
		fields.add(entity);
	}

}
