package com.fbitn.appframework;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fbitn.appframework.model.entity.RadioEntity;
import com.fbitn.appframework.model.entity.TextEntity;
import com.fbitn.appframework.repository.EntityMemoryRepo;
import com.fbitn.appframework.repository.EntityRepository;

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
	public CommandLineRunner clr(EntityRepository entityRepo) {
		
		return args -> {
			log.info("loading default data");
			entityRepo.insertOne(new TextEntity("name", "Enter your name:", ""));
			entityRepo.insertOne(new RadioEntity("discount", "Should apply discount?", "Yes", "Y", "No", "N"));			
			log.info("finished loading default data");
			
			
		};
	}
}
