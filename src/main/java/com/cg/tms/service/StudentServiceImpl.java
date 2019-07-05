package com.cg.tms.service;

import com.cg.tms.dao.IFetchAllDetails;
import com.cg.tms.dao.StudentServiceDao;
import com.cg.tms.dao.StudentServiceDaoImpl;
import com.cg.tms.entity.Program;
import com.cg.tms.entity.Student;
import com.cg.tms.exception.ProgramException;

public class StudentServiceImpl implements StudentService {
	
private StudentServiceDao studentOpn;
	

	
	
	

	public StudentServiceImpl() {
	this.studentOpn = new StudentServiceDaoImpl() ;
}

	public StudentServiceImpl(IFetchAllDetails<Student> studentOpn) {
		super();
		this.studentOpn = new StudentServiceDaoImpl() ;
	}

	@Override
	public boolean enrollStudent(Student student, Program program) throws ProgramException {
		boolean status=false;
		status = studentOpn.enrollStudent(student, program);
		return status;
	}

	@Override
	public boolean removeStudent(String studentId, String trainingProgramId) throws ProgramException {
		boolean status =studentOpn.removeStudent(studentId, trainingProgramId);
		return status;
	}

}
