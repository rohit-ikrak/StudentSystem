package com.projects.StudentSystem.service;

import java.util.List;
import java.util.Optional;

import com.projects.StudentSystem.model.Student;

public interface StudentService {
	public Student saveStudent(Student student);
	public List<Student> getAllStudents();
	public Student deleteStudent(int id);
	public Optional<Student> find(int id);
}
