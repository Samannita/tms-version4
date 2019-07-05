package com.cg.tms.dao;

import static org.junit.Assert.assertNotNull;


import java.time.LocalDate;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.tms.beans.Trainer;
import com.cg.tms.entity.Center;
import com.cg.tms.entity.Course;
import com.cg.tms.entity.Program;
import com.cg.tms.exception.ProgramException;

public class TrainingProgramServiceDaoImplTest {
	private static CrudService<Program> crudService ;

	@BeforeClass
	public static void init() throws ProgramException {
		crudService =  new TrainingProgramServiceDaoImpl();
	}
//	@Test
//	public void testCreate() throws ProgramException {
//		Program program = new Program("TP_1002", LocalDate.parse("2019-09-09"),
//				new Course("CO_1001", "JAVA", "JAVA Fundamentals", 2500),
//				new Trainer("EM_1001", "Mr Vivek Acharya", "Bhubaneswar,IND", DatabaseCollection.tr_1001Skills),
//				new Center("CN_1001", "Knowledge Park", "Thane Mumbai"));
//		crudService.create(program);
//	}

	@Test
	public void testUpdate() {
//		fail("Not yet implemented");
	}

	@Test(expected = ProgramException.class)
	public void testRetrieve() throws ProgramException {

		Program program = crudService.retrieve("TP_1001");
		assertNotNull("Program is null", program);
	}

	@Test(expected = ProgramException.class)
	public void testRetrieveAll() throws ProgramException {
		Set<Program> programs = crudService.retrieveAll();
		assertNotNull(programs);

	}

//	@Test
//	public void testDelete() throws ProgramException {
//		Program program = new Program("TP_1002", LocalDate.parse("2019-09-08"),
//				new Course("CO_1001", "JAVA", "JAVA Fundamentals", 2500),
//				new Trainer("EM_1001", "Mr Vivek Acharya", "Bhubaneswar,IND", DatabaseCollection.tr_1001Skills),
//				new Center("CN_1002", "Knowledge Park", "Thane Mumbai"));
//
//		crudService.delete(program);
//	}

}
