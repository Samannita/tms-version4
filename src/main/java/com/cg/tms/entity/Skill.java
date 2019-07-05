package com.cg.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "skill")
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SKILL")
	@SequenceGenerator(sequenceName = "seq_skill", allocationSize = 1, name = "SEQ_SKILL")

	@Column(name = "skillId")
	private String skillId;
	@Column(name = "employeeId")
	private String employeeId;
	@Column(name = "skill")
	private String skill;

	public Skill() {
	}

	public Skill(String skillId, String employeeId, String skill) {
		this.skillId = skillId;
		this.employeeId = employeeId;
		this.skill = skill;
	}

}
