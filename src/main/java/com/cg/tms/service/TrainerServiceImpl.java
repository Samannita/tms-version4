package com.cg.tms.service;

import java.util.*;

import com.cg.tms.beans.Trainer;
import com.cg.tms.dao.CourseServiceDaoImpl;
import com.cg.tms.dao.CrudService;
import com.cg.tms.dao.TrainerServiceDaoImpl;
import com.cg.tms.entity.Course;
import com.cg.tms.enums.Skills;
import com.cg.tms.exception.ProgramException;

/**
 * 
 */
public class TrainerServiceImpl implements TrainerService {
	CrudService<Trainer> crudOperation = new TrainerServiceDaoImpl();
	@Override
	public boolean addSkillsToTrainer(String trainerId, Skills skill) {
		return false;
	}

	@Override
	public boolean delSkillsToTrainer(String trainerId, Skills skills) {
		return false;
	}

	@Override
	public Trainer getTrainerDetails(String trainerId) throws ProgramException {
		Trainer trainer = crudOperation.retrieve(trainerId);

		return trainer;
	}

	@Override
	public Set<Trainer> getAllTrainers() throws ProgramException{
		return crudOperation.retrieveAll();
	}

	@Override
	public boolean createTrainer(Trainer trainer) {
		return false;
	}


}