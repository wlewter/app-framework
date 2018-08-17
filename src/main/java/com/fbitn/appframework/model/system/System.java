package com.fbitn.appframework.model.system;

import java.util.List;

import com.fbitn.appframework.model.view.Page;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class System {

	private String name;
	private List<Page> pages;
}
