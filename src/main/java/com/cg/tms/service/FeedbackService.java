package com.cg.tms.service;

import com.cg.tms.entity.Feedback;
import com.cg.tms.entity.Program;

public interface FeedbackService {

	public Feedback viewFeedbackReport();

	public Feedback viewDefaulterList(Program trainingProgram, Feedback feedback);
	
}