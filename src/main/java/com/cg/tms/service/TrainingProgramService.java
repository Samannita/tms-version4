package com.cg.tms.service;

import java.util.Set;

import com.cg.tms.entity.Program;
import com.cg.tms.exception.ProgramException;

/**
 * 
 */
public interface TrainingProgramService {

	/**
	 * @throws ProgramException 
	 * 
	 */
	public boolean createProgram(Program trainingProgram) throws ProgramException;

	/**
	 * @throws ProgramException 
	 * 
	 */
	public boolean deleteTrainingProgram(String trainingId) throws ProgramException;

	public boolean modifyTrainingProgram(Program trainingProgram);
	
	public Program retrieveTrainingProgram(String trainingId) throws ProgramException;
	
	public Set<Program> retrieveAllTrainingProgram() throws ProgramException;

	

}