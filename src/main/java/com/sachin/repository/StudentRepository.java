package com.sachin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sachin.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	//method for find by first name
	public List<Student> findByFirstName(String firstName);
	//method for matching firstName records getting from db
	public List<Student> findByFirstNameContaining(String name);
	//find by last name not null
	public List<Student> findByLastNameNotNull();
	//find by guardian name
	public List<Student> findByGuardianGuardianName(String guardianName);

}
