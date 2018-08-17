package com.fbitn.appframework.model.entity;

import lombok.Getter;

@Getter
public class TextEntity extends Entity {

	private String value;
	
	public TextEntity(String name, String label, String value) {
		super(name, label);
		this.value = value;
		this.entityType = EntityType.TEXT;
	}
	
	public TextEntity() {super();}
}
