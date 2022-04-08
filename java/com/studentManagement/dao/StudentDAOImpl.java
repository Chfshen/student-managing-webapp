package com.studentManagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.studentManagement.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Student> getStudents() {
		
		//get hibernate session
		Session session = sessionFactory.getCurrentSession();
		//create query
		Query<Student> query = session.createQuery("FROM Student order by lastName", Student.class);
		//get list
		List<Student> students = query.getResultList();
		
		return students;
	}

	@Override
	public void saveStudent(Student newStudent) {
		//get hibernate session
		Session session = sessionFactory.getCurrentSession();
		//save the new information
		session.save(newStudent);
	}

	@Override
	public Student getStudent(int id) {
		//get hibernate session
		Session session = sessionFactory.getCurrentSession();
		//get student information by id
		Student theStudent = session.get(Student.class, id);
		return theStudent;
	}

	@Override
	public void updateStudent(Student theStudent) {
		//get hibernate session
		Session session = sessionFactory.getCurrentSession();
		//update information
		session.update(theStudent);
	}

	@Override
	public void deleteStudent(int id) {
		//get hibernate session
		Session session = sessionFactory.getCurrentSession();
		//delete
		Query<Student> query = session.createQuery("DELETE FROM Student where id=:theId");
		query.setParameter("theId", id);
		query.executeUpdate();
	}

}
