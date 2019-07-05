package com.cg.tms.utility;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cg.tms.exception.ProgramException;
import com.cg.tms.util.UserInputValidator;

public class UserInputValidatorTest {

	@Test
	public void validCourseIdTest() throws ProgramException {
		assertTrue("Course Id format validation Failed ", UserInputValidator.validateCourseId("CD_1520"));
	}

	@Test
	public void invalidCourseIdTest() throws ProgramException {
		assertFalse("Course Id format validation Failed ", UserInputValidator.validateCourseId("CS_1520"));
	}

	@Test
	public void courseIdLengthTest() throws ProgramException {
		assertFalse("Course Id length validation Failed ", UserInputValidator.validateCourseId("CS_152"));

	}

	@Test
	public void validTrainerIdTest() throws ProgramException {
		assertTrue("Trainer Id format validation Failed ", UserInputValidator.validateEmployeeId("TR_1001"));
	}

	@Test
	public void invalidTrainerIdTest() throws ProgramException {
		assertFalse("Trainer Id format validation Failed ", UserInputValidator.validateEmployeeId("BD_1520"));
	}

	@Test
	public void trainerIdLengthTest() throws ProgramException {
		assertFalse("Trainer Id length validation Failed ", UserInputValidator.validateEmployeeId("TR 1520"));

	}

	@Test
	public void validCenterIdTest() throws ProgramException {
		assertTrue("Center Id format validation Failed ", UserInputValidator.validateCenterId("CN_1001"));
	}

	@Test
	public void invalidCenterIdTest() throws ProgramException {
		assertFalse("Center Id format validation Failed ", UserInputValidator.validateCenterId("Cp_1520"));
	}

	@Test
	public void centerIdLengthTest() throws ProgramException {
		assertFalse("Center Id length validation Failed ", UserInputValidator.validateCenterId("CN 1520"));

	}

	@Test
	public void validTrainingIdTest() throws ProgramException {
		assertTrue("Training Id format validation Failed ", UserInputValidator.validateTrainingId("TP_1001"));
	}

	@Test
	public void invalidTrainingIdTest() throws ProgramException {
		assertFalse("Training Id format validation Failed ", UserInputValidator.validateTrainingId("FP_1520"));
	}

	@Test
	public void trainingIdLengthTest() throws ProgramException {
		assertFalse("Training Id length validation Failed ", UserInputValidator.validateTrainingId("TP 1520"));

	}

}
