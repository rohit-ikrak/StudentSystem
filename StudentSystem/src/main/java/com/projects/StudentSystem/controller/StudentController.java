package com.projects.StudentSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.StudentSystem.model.Student;
import com.projects.StudentSystem.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/add")
	public String add(@RequestBody Student student) {
		studentService.saveStudent(student);
		return "New Student is added";
	}
	
	@GetMapping("/getall")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Student student) {
		studentService.saveStudent(student);
		return "data updated";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		studentService.deleteStudent(id);
		return "data deleted";
	}
	
	@GetMapping("/search/{id}")
	public Optional<Student> search(@PathVariable int id){
		return studentService.find(id);
	}
}
