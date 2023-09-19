package com.sachin.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sachin.entity.Course;
import com.sachin.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository repository;
	
	
	@Test
	void testSaveCourseMaterial() {
		Course course=Course.builder().title("DSA")
				.credit(6)
				.build();
		
		CourseMaterial courseMaterial=CourseMaterial.builder()
				.url("www.google.com")
				.course(course)
				.build();
		
		repository.save(courseMaterial);
	}
	
	@Test
	void printAllCourseMaterials() {
		List<CourseMaterial> findAll = repository.findAll();
		System.out.println(findAll);
	}
}
