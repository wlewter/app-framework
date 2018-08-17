package com.fbitn.appframework.repository;

import java.util.ArrayList;
import java.util.List;

import com.fbitn.appframework.model.view.Page;

public class PageMemoryRepo implements PageRepository {

	private List<Page> pages;
	
	public PageMemoryRepo() {
		pages = new ArrayList<>();
	}
	
	@Override
	public List<Page> getAll() {
		return pages;
	}
	
	@Override
	public void insertOne(Page page) {
		pages.add(page);
	}

	@Override
	public Page getOne(String name) {
		return pages.stream().filter(e -> e.getName().equalsIgnoreCase(name)).findFirst().get();
	}

}
