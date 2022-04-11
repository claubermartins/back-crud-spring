package com.clauber.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.clauber.exceptions.DuplicatedResourceException;
import com.clauber.exceptions.ResourceNotFoundException;
import com.clauber.model.Course;
import com.clauber.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public Page<Course> obterTodos(Pageable pageable) {
		return courseRepository.findAll(pageable);
	}

	public List<Course> obterTodos() {
		return courseRepository.findAll();
	}

	public Optional<Course> buscarPorId(Long id) {
		return courseRepository.findById(id);
	}

	public Optional<Course> buscaPorName(String name) {
		return courseRepository.findByNameIgnoreCase(name);
	}

	public List<Course> buscaPorNomeFiltro(String name) {
		return courseRepository.findByNameContainingIgnoreCase(name);
	}

	// CRUD
	public Course salvar(Course course) {
		var podeSalvar = course.getId() == null
				&& courseRepository.findByNameContainingIgnoreCase(course.getName()).isEmpty();
		if (podeSalvar)
			return courseRepository.save(course);
		else
			throw new DuplicatedResourceException();

	}
}
