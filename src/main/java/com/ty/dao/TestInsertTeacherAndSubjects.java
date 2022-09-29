package com.ty.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.dto.Subject;
import com.ty.dto.Teacher;

public class TestInsertTeacherAndSubjects {

	public static void main(String[] args) {
		Subject subject = new Subject();
		subject.setName("english");
		subject.setDuration(1);
		Subject subject1 = new Subject();
		subject1.setName("kannada");
		subject1.setDuration(1);
		Subject subject2 = new Subject();
		subject2.setName("maths");
		subject2.setDuration(1);
		List<Subject> ls = new ArrayList();
		ls.add(subject);
		ls.add(subject1);
		ls.add(subject2);
		Teacher teacher = new Teacher();
		teacher.setName("shilpa");
		teacher.setGender("female");
		teacher.setSubject(ls);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(subject);
		em.persist(subject1);
		em.persist(subject2);
		em.persist(teacher);
		et.commit();
		System.out.println("teacher along with corresponding subjects added");
	}
}