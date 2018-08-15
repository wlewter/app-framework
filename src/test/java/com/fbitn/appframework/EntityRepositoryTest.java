package com.fbitn.appframework;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fbitn.appframework.model.Entity;
import com.fbitn.appframework.model.RadioEntity;
import com.fbitn.appframework.model.TextEntity;
import com.fbitn.appframework.repository.EntityMemoryRepo;
import com.fbitn.appframework.repository.EntityRepository;

public class EntityRepositoryTest {

	private EntityRepository entityRepo;
	
	@Before
	public void setUp() {
		entityRepo = new EntityMemoryRepo();
	}
	
	@Test
	public void testRepo() {
		List<Entity> fields = entityRepo.getAll();
		assertThat(fields).size().isEqualTo(0);		
		
		entityRepo.insertOne(new TextEntity("name", "Enter your name:", 1, true, ""));
		
		fields = entityRepo.getAll();
		assertThat(fields).size().isEqualTo(1);
		
		entityRepo.insertOne(new RadioEntity("discount", "Should apply discount?", 2, true, "Yes", "Y", "No", "N"));
		fields = entityRepo.getAll();
		assertThat(fields).size().isEqualTo(2);
		
		Entity entity = entityRepo.getOne("discount");
		assertThat(entity).isInstanceOf(RadioEntity.class);
		
	}
}
