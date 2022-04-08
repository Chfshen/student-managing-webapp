package com.studentManagement.service;

import java.util.List;

import com.studentManagement.entity.Student;

public interface StudentListService {
	
	public List<Student> getStudents();
	
	public void saveStudent(Student newStudent);
	
	public Student getStudent(int id);
	
	public void updateStudent(Student theStudent);
	
	public void deleteStudent(int id);
}
