package com.fbitn.appframework;

import lombok.Getter;

@Getter
public class TextEntity extends Entity {

	private String value;
	
	public TextEntity(String name, String label, Integer order, boolean required, String value) {
		super(name, label, order, required);
		this.value = value;
		this.entityType = EntityType.TEXT;
	}
	
	public TextEntity() {super();}
}
