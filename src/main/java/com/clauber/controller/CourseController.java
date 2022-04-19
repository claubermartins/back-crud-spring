package com.clauber.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.clauber.model.Course;
import com.clauber.service.CourseService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/courses")
public class CourseController {
	
	private CourseService courseService;
	
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    
    @ApiOperation(value = "Lista de cursos")
	@GetMapping
	ResponseEntity<List<Course>> obterTodos(){
		var courses = courseService.obterTodos();
		return ResponseEntity.ok(courses);
	}
	
    @ApiOperation(value = "Busca de curso por id")
    @GetMapping("/{id}")
    ResponseEntity<Optional<Course>> obterPorId(@PathVariable Long id) {
    	var courses = courseService.buscarPorId(id);
        return ResponseEntity.ok(courses);
    }
    
    @ApiOperation(value = "Inserindo um curso novo")
    @PostMapping
    ResponseEntity<Course> salvar(@Valid @RequestBody Course course){
        var courseSalva = courseService.salvar(course);
        var uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(course.getId()).toUri();
        return ResponseEntity.created(uri).body(course);
    }
         
    @ApiOperation(value = "Atualizando as informações de um determinado curso")
    @PutMapping("/{id}")
    ResponseEntity<Course>update(@Valid @RequestBody  Course course){
        var courseUpdated = courseService.update(course);
        return ResponseEntity.ok(courseUpdated);
    }
    
    @ApiOperation(value = "Deletando um curso")
    @DeleteMapping
    ResponseEntity<Course> delete(@RequestBody Course course){
        courseService.delete(course);
        return ResponseEntity.ok().build();
    }

}
