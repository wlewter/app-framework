package com.fbitn.appframework.repository;

import java.util.List;

import com.fbitn.appframework.model.view.Page;

public interface PageRepository {

	public List<Page> getAll();
	public void insertOne(Page page);
	public Page getOne(String name);
}
