package com.cg.tms.dao;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.tms.entity.Course;
import com.cg.tms.exception.ErrorMessages;
import com.cg.tms.exception.ProgramException;
import com.cg.tms.util.EntityManagerUtils;


public class CourseServiceDaoImpl implements CrudService<Course> {
	Set<Course> courses = new HashSet<Course>();
	Iterator<Course> courseIterator = courses.iterator();

	@Override
	public boolean create(Course o) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public boolean update(Course o) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public Course retrieve(String courseId) throws ProgramException {

		Set<Course> courses;
		courses=retrieveAll();
		Course course=null;
		for (Course c : courses) {
			if (courseId.equals(c.getCourseId())) {
				course=c;
			}
		}
		if (course==null)
			throw new ProgramException(ErrorMessages.MESSAGE7);
		return course;
	}

	@Override
	public boolean delete(Course o) {
		// TODO Auto-generated method stub
//		courses.
		return false;
	}

	@Override
	public Set<Course> retrieveAll() {
		EntityManager entityManager = EntityManagerUtils.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		//entityTransaction.begin();
		Course course = entityManager.find(Course.class, "CO_1001");
		System.out.println(course);
		//entityManager.getTransaction().commit();
		entityManager.close();
		//courses.addAll(DatabaseCollection.course);
		return courses;
	}

}