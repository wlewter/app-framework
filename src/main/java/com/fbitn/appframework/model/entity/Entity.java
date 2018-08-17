package com.fbitn.appframework.model.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Getter;

@Getter
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "entityType", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = TextEntity.class, name = "TEXT"),
    @JsonSubTypes.Type(value = RadioEntity.class, name = "RADIO")
})
public class Entity {

	private String name;
	private String label;
	protected EntityType entityType;
	
	public Entity() {}
	
	public Entity(String name, String label) {
		this.name = name;
		this.label = label;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
