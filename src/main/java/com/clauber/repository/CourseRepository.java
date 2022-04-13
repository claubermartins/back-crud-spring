package com.clauber.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clauber.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	List<Course> findByNameContainingIgnoreCase(String name);

	Optional<Course> findByNameIgnoreCase(String name);

	Optional<Course> findByEmail(String email);
}
