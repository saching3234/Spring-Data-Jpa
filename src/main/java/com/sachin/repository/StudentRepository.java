package com.sachin.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

	//JPQL
	@Query("select s from Student s where s.emailId=?1")
	Student getStudentByEmail(String email);
	
	//JPQL For getting the student name based on the email id
	@Query("select s.firstName from Student s where s.emailId=?1")
	String getStudentsNameByEmail(String email);
	
	//Native Query
	@Query(
			value = "select * from tbl_student s where s.email_address=?1",
			nativeQuery = true
			)
	Student getStudentByEmailNative(String email);
	
	//Native Query With the named param
		@Query(
				value = "select * from tbl_student s where s.email_address=:email",
				nativeQuery = true
				)
		Student getStudentByEmailNativeParam(@Param("email") String email);
		
	@Modifying
	@Transactional
	@Query(
			value = "update tbl_student set first_name=?1 where email_address=?2",
			nativeQuery = true
			)	
	int updateStudentNameByEmailId(String firstName,String emailId);
	
	
}
