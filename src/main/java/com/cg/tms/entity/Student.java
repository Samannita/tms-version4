package com.cg.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STUDENT")
	@SequenceGenerator(sequenceName = "seq_student", allocationSize = 1, name = "SEQ_STUDENT")

	@Column(name="studentId")
	private String studentId;
	
	@Column(name="studentName")
	private String studentName;
	
	@OneToOne
	@Column(name="trainingId")
	private Program program;
	public transient static int studentSeq = 10;
	
	public Student() {};

	public Student(String studentId, String studentName, Program program) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.program = program;
		studentSeq++;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public int hashCode() {
		return this.studentId.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.getStudentId().equals(((Student) obj).getStudentId());
	}

	@Override
	public String toString() {
		return "Student Id " + getStudentId() + "Name: " + getStudentName();
	}

}