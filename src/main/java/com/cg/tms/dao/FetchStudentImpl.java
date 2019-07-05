package com.cg.tms.dao;

import java.util.List;

import com.cg.tms.entity.Center;
import com.cg.tms.entity.Student;

public class FetchStudentImpl implements IFetchAllDetails<Student> {

	@Override
	public List<Student> retrieveAll() {
		List<Student> student ;
		 student= DatabaseCollection.student;
			return student;
		
	}

	@Override
	public Student retrieve(String id) {
		List<Student> students=retrieveAll();
		Student student=null;
		for (Student s:students) {
			if (s.getStudentId().equals(id)) {
				student=s;
				break;
			}
		}
		return student;
	}

}
