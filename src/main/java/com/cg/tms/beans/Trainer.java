package com.cg.tms.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cg.tms.entity.Employee;
import com.cg.tms.enums.Skills;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "skill")
public class Trainer extends Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToMany()
	@JoinColumn(name = "skill")
	@Enumerated(EnumType.STRING)
	private Set<Skills> skills;

	public static int trainerSeq = 10;

	public Trainer(String trainerId, String trainerName, String trainerAddress, Set<Skills> skills) {
		super(trainerId, trainerName);
		this.skills = skills;
		trainerSeq++;
	}

	public Trainer() {
	}

	public Set<Skills> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skills> skills) {
		this.skills = skills;
	}

}