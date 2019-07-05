package com.cg.tms.entity;

public class Feedback {

	/**
	 * Default constructor
	 */
	public Feedback() {
	}

	private Student participant;
	private Program trainingProgram;
	private Question  questionId;
	private int rating;
	
	
	
	public Feedback(Student participant, Program trainingProgram, Question questionId, int rating) {
		this.participant = participant;
		this.trainingProgram = trainingProgram;
		this.questionId = questionId;
		this.rating = rating;
	}
	
	
	public Student getParticipant() {
		return participant;
	}
	public void setParticipant(Student participant) {
		this.participant = participant;
	}
	public Program getTrainingProgram() {
		return trainingProgram;
	}
	public void setTrainingProgram(Program trainingProgram) {
		this.trainingProgram = trainingProgram;
	}
	public Question getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Question questionId) {
		this.questionId = questionId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	




}