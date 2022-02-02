package com.clauber.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clauber.model.Course;
import com.clauber.repository.CourseRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

	private CourseRepository courseRepository;

	// RequestMapping(method = RequestMethod.Get)
	@GetMapping
	public List<Course> list() {
		return courseRepository.findAll();
	}

}
