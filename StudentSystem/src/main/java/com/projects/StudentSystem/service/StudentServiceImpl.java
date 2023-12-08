package com.projects.StudentSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.StudentSystem.model.Student;
import com.projects.StudentSystem.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	
	@Override
	public Student deleteStudent(int id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
		return null;
	}
	
	@Override
	public Optional<Student> find(int id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id);
	}
}
