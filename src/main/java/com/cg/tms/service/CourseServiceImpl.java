package com.cg.tms.service;

import java.util.*;


import com.cg.tms.dao.CourseServiceDaoImpl;
import com.cg.tms.dao.CrudService;
import com.cg.tms.entity.Course;
import com.cg.tms.exception.ProgramException;


/**
 * 
 */
public class CourseServiceImpl implements CourseService {
	CrudService<Course> crudOperation = new CourseServiceDaoImpl();
	
	@Override
	public boolean addCourse(Course course) throws ProgramException {

		boolean flag = false;

		flag = crudOperation.create(course);

		return flag;
	}

	@Override
	public boolean deleteCourse(Course course) throws ProgramException {
		boolean flag = false;

		flag = crudOperation.delete(course);

		return flag;

	}

//	@Override
//	public boolean modifyCourse(Course course) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public Set<Course> getAllCourse() throws ProgramException {
		return crudOperation.retrieveAll();
	}

	@Override
	public Course getCourseDetails(final String courseId) throws ProgramException {
		Course course = crudOperation.retrieve(courseId);
		return course;
	}

}