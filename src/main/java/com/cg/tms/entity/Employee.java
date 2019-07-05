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
@Table(name = "employee")
public class Employee {

	/**
	 * Default constructor
	 * 
	 */
	public Employee() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMPLOYEE")
	@SequenceGenerator(sequenceName = "seq_employee", allocationSize = 1, name = "SEQ_EMPLOYEE")

	@Column(name = "employeeId")
	private String empId;
	@Column(name = "employeeName")
	private String empName;

	@OneToOne
	@Column(name = "roleid")
	private Roles role;

	public Employee(String empName, String empId) {
		this.empName = empName;
		this.empId = empId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

}