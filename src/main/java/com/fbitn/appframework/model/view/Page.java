package com.fbitn.appframework.model.view;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Page {

	private String name;
	private List<PageEntity> entities;
}
