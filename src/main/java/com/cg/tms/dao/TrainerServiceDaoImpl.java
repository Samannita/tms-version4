package com.cg.tms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.cg.tms.beans.Trainer;
import com.cg.tms.enums.Skills;
import com.cg.tms.exception.ErrorMessages;
import com.cg.tms.exception.ProgramException;
import com.cg.tms.util.ConnectionDB;
import com.cg.tms.util.DBQueries;

/**
 * 
 */

public class TrainerServiceDaoImpl implements CrudService<Trainer> {
	private Connection connection;

//	Iterator<Trainer> trainerIterator = trainers.iterator();
	@Override
	public boolean create(Trainer o) {
		return false;
	}

//	@Override
//	public boolean update(Trainer o) {
//		return false;
//	}

	@Override
	public Trainer retrieve(String trainerId) throws ProgramException {
		Set<Trainer> trainerSet = retrieveAll();
		for (Trainer trainer : trainerSet) {
			if (trainerId.equals(trainer.getEmpId())) {
				return trainer;
			}
		}

		return null;
	}

	@Override
	public boolean delete(Trainer o) {
		return false;
	}

	@Override
	public Set<Trainer> retrieveAll() throws ProgramException {
		connection = ConnectionDB.getConnection();
		Set<Trainer> trainers = new HashSet<Trainer>();
		final String trainersql = DBQueries.GET_ALL_TRAINER;
		final String skillSql = DBQueries.GET_SKILL_FOR_TRAINER;

		try {
			PreparedStatement preparedStatementTrainers = connection.prepareStatement(trainersql);
//			PreparedStatement preparedStatementSkills;
			ResultSet resultSetforTrainers = preparedStatementTrainers.executeQuery();
			

			while (resultSetforTrainers.next()) {
				Trainer trainer = new Trainer();
		
				trainer.setEmpId(resultSetforTrainers.getString(1));
				trainer.setEmpName(resultSetforTrainers.getString(2));
				
				PreparedStatement preparedStatementSkills= connection.prepareStatement(skillSql);
				preparedStatementSkills.setString(1, resultSetforTrainers.getString(1));
				ResultSet resultSet = preparedStatementSkills.executeQuery();
//				preparedStatementSkills.clearParameters();
				Set<Skills> skills = new HashSet<Skills>();

				while (resultSet.next()) {
					skills.add(Skills.valueOf(resultSet.getString(1)));
				}
				resultSet.close();
				trainer.setSkills(skills);

				trainers.add(trainer);
			}

//			preparedStatementSkills.close();
			resultSetforTrainers.close();
			preparedStatementTrainers.close();


		} catch (SQLException e) {
			try {
				connection.close();
			} catch (SQLException e1) {
				throw new ProgramException(ErrorMessages.MESSAGE3);
			}
			throw new ProgramException(ErrorMessages.MESSAGE2);
		}

//		trainers.addAll(DatabaseCollection.trainer);
		return trainers;

	}

}