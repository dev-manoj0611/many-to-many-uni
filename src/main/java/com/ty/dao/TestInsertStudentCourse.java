package com.ty.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Course;
import com.ty.dto.Student;

public class TestInsertStudentCourse {

	public static void main(String[] args) {
		Student student = new Student();
		student.setName("susheel");
		student.setEmail("susheel@gmail.com");
		Course course = new Course();
		course.setName("ME");
		course.setCost(35000);
		Course course1 = new Course();
		course1.setName("AE");
		course1.setCost(35000);
		Course course2 = new Course();
		course2.setName("TCE");
		course2.setCost(37000);
		List<Course> courses = new ArrayList();
		courses.add(course);
		courses.add(course1);
		courses.add(course2);
		student.setCourse(courses);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(student);
		em.persist(course);
		em.persist(course1);
		em.persist(course2);
		et.commit();
		System.out.println("Student along with course details are added");
	}
}