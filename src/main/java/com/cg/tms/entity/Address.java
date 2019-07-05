package com.cg.tms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ADDRESS")
	@SequenceGenerator(sequenceName = "seq_address", allocationSize = 1, name = "SEQ_ADDRESS")
	@Column(name = "id")
	private int id;
	@Column(name = "line1")
	private String line1;
	@Column(name = "line2")
	private String line2;
	@Column(name = "line3")
	private String line3;
	@Column(name = "pin")
	private int pin;

	public Address() {
	}

	public Address(int id, String line1, String line2, String line3, int pin) {
		super();
		this.id = id;
		this.line1 = line1;
		this.line2 = line2;
		this.line3 = line3;
		this.pin = pin;
	}

}
