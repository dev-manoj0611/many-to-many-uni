package com.ty.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Course;
import com.ty.dto.Student;

public class TestInsertStudentForExistingCourse {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		List<Course> lc = new ArrayList();
		Course c = em.find(Course.class, 1);
		Course c1 = em.find(Course.class, 2);
		lc.add(c);
		lc.add(c1);
		Student student = new Student();
		student.setName("shaila");
		student.setEmail("shaila@gmail.com");
		student.setCourse(lc);
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(student);
		em.persist(c);
		em.persist(c1);
		et.commit();
		System.out.println("Saved");
	}
}