package com.cg.tms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.cg.tms.beans.Trainer;
import com.cg.tms.entity.Center;
import com.cg.tms.entity.Course;
import com.cg.tms.entity.Program;
import com.cg.tms.exception.ErrorMessages;
import com.cg.tms.exception.ProgramException;
import com.cg.tms.util.ConnectionDB;
import com.cg.tms.util.DBQueries;

/*Dao implementation class for Training Program management
 * */
public class TrainingProgramServiceDaoImpl implements CrudService<Program> {
	/* Constructor for initializing the Connection object */
	/***
	 * 
	 * / /* create method takes a program object and extract the value as courseId,
	 * trainerId, centerId, startDate and insert the program in databases
	 */
	@Override
	public boolean create(final Program program) throws ProgramException {
		int creationStatus = 0;
		boolean flag = false;
		final String sql = DBQueries.CREATE_PROGRAM;
		final Connection connection = ConnectionDB.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, program.getTrainingId());
			preparedStatement.setString(2, program.getCourse().getCourseId());
			preparedStatement.setString(3, program.getTrainer().getEmpId());
			preparedStatement.setString(4, program.getCenter().getCenterId());
			preparedStatement.setDate(5, java.sql.Date.valueOf(program.getTrainingStartDate()));

//			preparedStatement.setString(5, program.getTrainingStartDate().toString());
			/* alternate code: java.sql.Date.valueOf(program.getTrainingStartDate()) */

			creationStatus = preparedStatement.executeUpdate();
			connection.commit();
			preparedStatement.close();
			if (creationStatus != 0) {
				flag = true;
			}
		} catch (SQLException e) {
e.printStackTrace();
			throw new ProgramException(ErrorMessages.MESSAGE4);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				throw new ProgramException(ErrorMessages.MESSAGE3);
			}
		}
		return flag;
	}

//	@Override
//	public boolean update(final Program program) {
//		/* Not yet defined */
//		return false;
//	}

	/*
	 * retrieve method will take training id and return the program object with
	 * appropriate attributes
	 */
	@Override
	public Program retrieve(final String trainingId) throws ProgramException {
		final String sql = DBQueries.GET_PROGRAM_ID;
		final Connection connection = ConnectionDB.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, trainingId);
			resultSet = preparedStatement.executeQuery();
			Program program = null;
			while (resultSet.next()) {

				final LocalDate trainingStartDate = LocalDate.parse(resultSet.getDate(5).toString());
				final Course course = new CourseServiceDaoImpl().retrieve(resultSet.getString(2));
				final Trainer trainer = new TrainerServiceDaoImpl().retrieve(resultSet.getString(3));
				final Center center = new FetchCentersImpl().retrieve(resultSet.getString(4));

				program = new Program(trainingId, trainingStartDate, course, trainer, center);
			}
			resultSet.close();
			preparedStatement.close();
			return program;

		} catch (SQLException e) {
			try {
				resultSet.close();
				preparedStatement.close();
			} catch (SQLException e1) {
				throw new ProgramException(ErrorMessages.MESSAGE3);
			}
			throw new ProgramException(ErrorMessages.MESSAGE4);
		}
	}

	/*
	 * This method will require program id for deleting the object. It will acquire
	 * the trainingId from program object
	 */
	@Override
	public boolean delete(final Program program) throws ProgramException {
		boolean flag = false;
		final Connection connection = ConnectionDB.getConnection();
		final String sql = DBQueries.DELETE_PROGRAM_BY_ID;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, program.getTrainingId());
			flag = preparedStatement.execute();
			preparedStatement.close();
			connection.commit();
		} catch (SQLException e) {
			try {
				preparedStatement.close();
			} catch (SQLException e1) {
				throw new ProgramException(ErrorMessages.MESSAGE5);
			}
		}
		return flag;
	}

	/* Below method will return set of all the available programs */
	@Override
	public Set<Program> retrieveAll() throws ProgramException {
		final Connection connection = ConnectionDB.getConnection();
		final String sql = DBQueries.GET_PROGRAMS;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Set<Program> programs = new HashSet<Program>();
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				final String trainingId = resultSet.getString(1);
//				final LocalDate trainingStartDate = resultSet.getDate(5).toLocalDate();
				final LocalDate trainingStartDate = LocalDate.parse(resultSet.getDate(5).toString());

				final Course course = new CourseServiceDaoImpl().retrieve(resultSet.getString(2));
				final Trainer trainer = new TrainerServiceDaoImpl().retrieve(resultSet.getString(3));
				final Center center = new FetchCentersImpl().retrieve(resultSet.getString(4));

				Program program = new Program(trainingId, trainingStartDate, course, trainer, center);
				programs.add(program);
			}
			resultSet.close();
			preparedStatement.close();

		} catch (SQLException e) {
			try {
				resultSet.close();
				preparedStatement.close();
			} catch (SQLException e1) {
				throw new ProgramException(ErrorMessages.MESSAGE3);
			}
			throw new ProgramException(ErrorMessages.MESSAGE2);

		}
		return programs;
		/*
		 * Previous static database Codes // Map<String, Program> map =
		 * DatabaseCollection.program; // if (map == null) { // throw new
		 * DatabaseWriteException("Data not Available in the Database"); // } //
		 * Set<Program> trainingPrograms = new HashSet<Program>(); // for (Program
		 * program : map.values()) { // trainingPrograms.add(program); // } // return
		 * trainingPrograms;
		 */

	}

}