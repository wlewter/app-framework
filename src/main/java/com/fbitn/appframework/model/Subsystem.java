package com.fbitn.appframework.model;

import java.util.List;

import com.fbitn.appframework.model.view.Page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Subsystem {

	private String name;
	private List<Page> pages;
}
