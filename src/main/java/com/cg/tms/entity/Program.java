package com.cg.tms.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cg.tms.beans.Trainer;

/**
 * 
 */
@Entity
@Table(name = "program")
public class Program implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROGRAM")
	@SequenceGenerator(sequenceName = "seq_program", allocationSize = 1, name = "SEQ_PROGRAM")

	@Column(name = "trainingId")
	private String trainingId;
	@Column(name = "startDate")
	private LocalDate trainingStartDate;
	@OneToOne
	@JoinColumn(name = "courseId")
	private Course course;
	@OneToOne
	@JoinColumn(name = "trainerId")
	private Trainer trainer;
	@OneToOne
	@JoinColumn(name = "centerId")
	private Center center;
	public static transient int tProgramSeq = 10;

	public static final Comparator<Program> BY_TRAININGID = Comparator.comparing(Program::getTrainingId);

	public Program() {
	};

	public Program(String trainingId, LocalDate trainingStartDate, Course course, Trainer trainer, Center center) {

		this.trainingId = trainingId;
		this.trainingStartDate = trainingStartDate;
		this.course = course;
		this.trainer = trainer;
		this.center = center;
		tProgramSeq++;

	}

	public String getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(String trainingId) {
		this.trainingId = trainingId;
	}

	public LocalDate getTrainingStartDate() {
		return trainingStartDate;
	}

	public void setTrainingStartDate(LocalDate trainingStartDate) {
		this.trainingStartDate = trainingStartDate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	@Override
	public String toString() {
		return "Training ID: " + trainingId + " Start Date: " + trainingStartDate + " Course " + course.getCourseName()
				+ " Trainer " + trainer.getEmpName() + " Center Name: " + center.getCenterName();
	}

}