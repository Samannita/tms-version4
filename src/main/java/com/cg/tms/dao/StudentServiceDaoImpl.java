package com.cg.tms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cg.tms.entity.Program;
import com.cg.tms.entity.Student;
import com.cg.tms.exception.ErrorMessages;
import com.cg.tms.exception.ProgramException;
import com.cg.tms.util.ConnectionDB;
import com.cg.tms.util.DBQueries;

public class StudentServiceDaoImpl implements StudentServiceDao {

	@Override
	public boolean enrollStudent(Student student, Program program) throws ProgramException {
		
		boolean flag= false;
		int returnValue;
		final String sql = DBQueries.ENROLL_STUDENT;
//		TrainingProgram trainingProgram = new TrainingProgram(student,program);
		System.out.println(student.getStudentId()+" "+student.getStudentName()+" "+program.getTrainingStartDate());
		Connection connection = ConnectionDB.getConnection();
		PreparedStatement preparedStatement=null;
	
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, student.getStudentId());
			preparedStatement.setString(2, student.getStudentName());
			preparedStatement.setString(3, program.getTrainingId());
			
			returnValue= preparedStatement.executeUpdate();
			System.out.println("222222");
			if (returnValue!=0) {
				flag= true;
			}
			return flag;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProgramException(ErrorMessages.MESSAGE4);
		}
		
	}

	@Override
	public boolean removeStudent(String studnentId, String trainingProgramId) throws ProgramException {
		boolean flag= false;
		int returnValue;
		final String sql = DBQueries.DELETE_STUDENT;
		Connection connection = ConnectionDB.getConnection();
		PreparedStatement preparedStatement=null;
		
		try {
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, studnentId);
			preparedStatement.setString(2, trainingProgramId);
			
			returnValue = preparedStatement.executeUpdate();
			if (returnValue!=0) {
				flag= true;
			}
			System.out.println("exec");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ProgramException(ErrorMessages.MESSAGE11);
		}
		return flag;
	}

}
