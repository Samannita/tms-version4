package com.cg.tms.service;

import com.cg.tms.entity.Program;
import com.cg.tms.entity.Student;
import com.cg.tms.exception.ProgramException;

public interface StudentService {
	boolean enrollStudent(Student student, Program program) throws ProgramException;
	boolean removeStudent(String studentId, String trainingProgramId)throws ProgramException;
	
}
