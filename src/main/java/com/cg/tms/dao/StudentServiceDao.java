package com.cg.tms.dao;

import com.cg.tms.entity.Program;
import com.cg.tms.entity.Student;
import com.cg.tms.exception.ProgramException;

public interface StudentServiceDao {
  boolean enrollStudent(Student student,Program program) throws ProgramException;
  boolean removeStudent(String studnentId,String trainingProgramId) throws ProgramException;
}
