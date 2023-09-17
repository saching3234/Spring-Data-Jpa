package com.sachin.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.ToStringConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sachin.entity.Guardian;
import com.sachin.entity.Student;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	//@Test
	public void saveStudent() {
		Student student=Student.builder().emailId("sachin@gmail.com")
				.firstName("sachin")
				.lastName("gawade")
			//	.guardianName("Ketan")
				//.guardianMobile("9090909090")
				//.guardianEmail("ketan@gmail.com")
				.build();
		Student savedtStudent = studentRepository.save(student);
		System.out.println(savedtStudent);
	}
	
	

	//@Test
	public void saveStudentWithGuardian() {
		Guardian guardian=Guardian.builder().guardianName("sachin")
				.guardianEmail("sachin@gmail.com")
				.guardianMobile("7020498612")
				.build();
		Student student=Student.builder().emailId("nana@gmail.com")
				.firstName("nana")
				.lastName("gawade")
				.guardian(guardian)
				.build();
		Student savedtStudent = studentRepository.save(student);
		System.out.println(savedtStudent);
	}
	
	@Test
	public void printAllStudent() {
		List<Student> allStudentList = studentRepository.findAll();
		System.out.println("--------------All Students present in the lists are :-----------------\n");
		allStudentList.stream().forEach(s->System.out.println(s.toString()));
		System.out.println("--------------------------------------------------------------------------\n");
	}
	
	@Test
	public void findByFirstName() {
		List<Student> findByFirstName = studentRepository.findByFirstName("nana");
		System.out.println(findByFirstName.get(0));
	}
	
	@Test
	public void findByFirstNameContaining() {
		List<Student> findByFirstNameContaining = studentRepository.findByFirstNameContaining("a");
		findByFirstNameContaining.stream().forEach(s->System.out.println(s.toString()));
	}
	
	@Test
	public void findByGuardianName() {
		List<Student> findByGuardianName = studentRepository.findByGuardianGuardianName("sachin");
		findByGuardianName.stream().forEach(s->System.out.println(s.toString()));
	}
	
	@Test
	public void findByLastNameNotNull() {
		List<Student> findByLastNameNotNull = studentRepository.findByLastNameNotNull();
		findByLastNameNotNull.stream().forEach(s->System.out.println(s.toString()));
	}

}
