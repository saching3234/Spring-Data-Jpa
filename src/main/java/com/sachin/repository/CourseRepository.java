package com.sachin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sachin.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
