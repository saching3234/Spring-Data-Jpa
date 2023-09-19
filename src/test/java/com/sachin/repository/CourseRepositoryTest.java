package com.sachin.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sachin.entity.Course;

@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;
	
	
	@Test
	void testGetAllCourses() {
		
		List<Course> findAll = courseRepository.findAll();
		System.out.println(findAll);
		
		
	}

}
