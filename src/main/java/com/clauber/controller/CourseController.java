package com.clauber.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.clauber.model.Course;
import com.clauber.service.CourseService;


@RestController
@RequestMapping("/api/courses")
public class CourseController {
	
	private CourseService courseService;
	
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    
	@GetMapping
	@ResponseBody
	ResponseEntity<List<Course>> obterTodos(){
		var courses = courseService.obterTodos();
		return ResponseEntity.ok(courses);
	}
	
    @GetMapping("/{id}")
    ResponseEntity<Optional<Course>> obterPorId(@PathVariable Long id) {
    	var courses = courseService.buscarPorId(id);
        return ResponseEntity.ok(courses);
    }
    
    @PostMapping
    ResponseEntity<Course> salvar(@RequestBody Course course){
        var courseSalva = courseService.salvar(course);
        var uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(course.getId()).toUri();
        return ResponseEntity.created(uri).body(course);
    }

}
