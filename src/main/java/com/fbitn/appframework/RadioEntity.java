package com.fbitn.appframework;

import lombok.Getter;

@Getter
public class RadioEntity extends Entity {

	private String option1Label;
	private String option1Value;
	private String option2Label;
	private String option2Value;
	
	public RadioEntity(String name, String label, Integer order, boolean required, String option1Label, String option1Value, String option2Label, String option2Value) {
		super(name, label, order, required);
		this.option1Label = option1Label;
		this.option1Value = option1Value;
		this.option2Label = option2Label;
		this.option2Value = option2Value;
		this.entityType = EntityType.RADIO;
	}
}
