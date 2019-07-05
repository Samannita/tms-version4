package com.cg.tms.service;

import java.util.Set;

import com.cg.tms.dao.CrudService;
import com.cg.tms.dao.TrainingProgramServiceDaoImpl;
import com.cg.tms.entity.Program;
import com.cg.tms.exception.ErrorMessages;
import com.cg.tms.exception.ProgramException;

/**
 * Training Program service IMPL class:
 * 
 */
public class TrainingProgramServiceImpl implements TrainingProgramService {
	final private CrudService<Program> crudTrainingProgram ;
	
	public TrainingProgramServiceImpl() throws ProgramException {
		crudTrainingProgram = new TrainingProgramServiceDaoImpl();
	}

	@Override
	public boolean createProgram(final Program trainingProgram) throws ProgramException {
		boolean flag = false;
		flag = crudTrainingProgram.create(trainingProgram);
		return flag;
	}

	@Override
	public boolean deleteTrainingProgram(final String trainingId) throws ProgramException {
		final Program program = retrieveTrainingProgram(trainingId);
		if (program == null) {
			throw new ProgramException(ErrorMessages.MESSAGE9);
		}
		crudTrainingProgram.delete(program);
		return true;
	}

	@Override
	public boolean modifyTrainingProgram(final Program trainingProgram) {
		/* Not yet implemented */
		return false;
	}

//	public boolean validateCourse(String courseId)
//			throws ProgramException {
//		final Course course = crudOnCourse.retrieve(courseId);
//		if (course != null)
//			return true;
//		else
//			return false;
//
//	}

	@Override
	public Program retrieveTrainingProgram(final String trainingId) throws ProgramException {
		final Set<Program> trainingPrograms = retrieveAllTrainingProgram();
		Program program = null;
		for (Program trainingProgram : trainingPrograms) {
			if (trainingProgram.getTrainingId().equals(trainingId)) {
				program = trainingProgram;
				break;
			}
		}
		if (program == null) {
			throw new ProgramException(ErrorMessages.MESSAGE9);
		}
		return program;
	}

	@Override
	public Set<Program> retrieveAllTrainingProgram() throws ProgramException {
		Set<Program> trainingPrograms;
		trainingPrograms = crudTrainingProgram.retrieveAll();
		return trainingPrograms;
	}

}