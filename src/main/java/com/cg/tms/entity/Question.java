package com.cg.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="questions")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_QUESTION")
	@SequenceGenerator(sequenceName = "seq_question", allocationSize = 1, name = "SEQ_QUESTION")

	@Column(name = "questionId")
	private String questionId;
	@Column(name="criteria")
	private String criteria;
	
	public Question() {}
	
	public Question(String questionId, String criteria) {
		super();
		this.questionId = questionId;
		this.criteria = criteria;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getCriteria() {
		return criteria;
	}
	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}
	
	

}
