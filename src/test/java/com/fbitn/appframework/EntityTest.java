package com.fbitn.appframework;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fbitn.appframework.model.entity.Entity;
import com.fbitn.appframework.model.entity.RadioEntity;
import com.fbitn.appframework.model.entity.TextEntity;

public class EntityTest {

	private List<Entity> fields;
	
	@Before
	public void setUp() {
		fields = new ArrayList<>();
		
		fields.add(new TextEntity("name", "Enter your name:", ""));
		fields.add(new RadioEntity("discount", "Should apply discount?", "Yes", "Y", "No", "N"));
	}
	
	@Test
	public void testContains() {
				
		assertThat(fields).contains(new TextEntity("name", null, null));
		assertThat(fields).contains(new RadioEntity("discount", null, null, null, null, null));
	}
	
//	@Test
//	public void testSort() {
//		fields.sort(Comparator.comparingInt(Entity::getOrder));
//		
//		assertThat(fields.get(0).getName()).isEqualTo("name");
//		
//		fields.sort(Comparator.comparingInt(Entity::getOrder).reversed());
//		
//		assertThat(fields.get(0).getName()).isEqualTo("discount");
//	}
}
