package com.studentManagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.studentManagement.dao.StudentDAO;
import com.studentManagement.entity.Student;

@Service
public class StudentListServiceImpl implements StudentListService {
	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	@Transactional
	public List<Student> getStudents() {	
		return studentDAO.getStudents();
	}

	@Override
	@Transactional
	public void saveStudent(Student newStudent) {
		studentDAO.saveStudent(newStudent);
	}

	@Override
	@Transactional
	public Student getStudent(int id) {
		return studentDAO.getStudent(id);
	}

	@Override
	@Transactional
	public void updateStudent(Student theStudent) {
		studentDAO.updateStudent(theStudent);
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		studentDAO.deleteStudent(id);
	}

}
