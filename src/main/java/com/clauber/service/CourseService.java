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

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public Page<Course> obterTodos(Pageable pageable) {
		return courseRepository.findAll(pageable);
	}

	public List<Course> obterTodos() {
		return courseRepository.findAll();
	}

	public Optional<Course> buscarPorId(Long id) {
		return courseRepository.findById(id);
	}
	
    public Optional<Course> buscaPorCpf(String email){
        return courseRepository.findByEmail(email);
    }

	public Optional<Course> buscaPorName(String name) {
		return courseRepository.findByNameIgnoreCase(name);
	}

	public List<Course> buscaPorNomeFiltro(String name) {
		return courseRepository.findByNameContainingIgnoreCase(name);
	}

	// CRUD
	public Course salvar(Course course) {
		var podeSalvar = course.getId() == null && courseRepository.findByEmail(course.getEmail()).isEmpty();
		if (podeSalvar)
			return courseRepository.save(course);
		else
			throw new DuplicatedResourceException();

	}

	public Course update(Course course) {
		var podeAtualizar = course.getId() != null
				&& courseRepository.findByEmail(course.getEmail()).isPresent();
		if (podeAtualizar)
			return courseRepository.save(course);
		else
			throw new ResourceNotFoundException();
	}

	public void delete(Course course) {
		var podeDeletar = course.getId() != null && courseRepository.findByNameIgnoreCase(course.getName()).isPresent();
		if (podeDeletar)
			courseRepository.delete(course);
		else
			throw new ResourceNotFoundException();
	}
}