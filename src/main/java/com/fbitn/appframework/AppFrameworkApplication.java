package com.fbitn.appframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fbitn.appframework.model.Subsystem;
import com.fbitn.appframework.model.entity.Entity;
import com.fbitn.appframework.model.entity.RadioEntity;
import com.fbitn.appframework.model.entity.TextEntity;
import com.fbitn.appframework.model.view.Page;
import com.fbitn.appframework.model.view.PageEntity;
import com.fbitn.appframework.repository.EntityMemoryRepo;
import com.fbitn.appframework.repository.EntityRepository;
import com.fbitn.appframework.repository.PageMemoryRepo;
import com.fbitn.appframework.repository.PageRepository;
import com.fbitn.appframework.repository.SubsystemMemoryRepo;
import com.fbitn.appframework.repository.SubsystemRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class AppFrameworkApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AppFrameworkApplication.class, args);
	}
	
	@Bean
	public EntityRepository entityRepository() {
		return new EntityMemoryRepo();
	}

	@Bean
	public PageRepository pageRepository() {
		return new PageMemoryRepo();
	}

	@Bean
	public SubsystemRepository subsystemRepository() {
		return new SubsystemMemoryRepo();
	}
	
	@Bean
	public CommandLineRunner clr(EntityRepository entityRepo, PageRepository pageRepo, SubsystemRepository subsysRepo) {
		
		return args -> {			
			log.info("loading default data");						
			entityRepo.insertOne(new TextEntity("name", "Enter your name:", ""));
			entityRepo.insertOne(new RadioEntity("discount", "Should apply discount?", "Yes", "Y", "No", "N"));
			
			int order = 0;
			List<PageEntity> pageEntities = new ArrayList<>();
			for(Entity entity : entityRepo.getAll() ) {
				pageEntities.add(new PageEntity(order, true, entity));
				order++;
			}			
			pageRepo.insertOne(new Page("Test Page", pageEntities));
			
			subsysRepo.insertOne(new Subsystem("Test System", pageRepo.getAll()));
			
			log.info("finished loading default data");
			
			
		};
	}
}
