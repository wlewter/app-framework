package com.fbitn.appframework.model.view;

import com.fbitn.appframework.model.entity.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PageEntity {

	private int order;
	private boolean required;
	private Entity entity;
	
	
}
