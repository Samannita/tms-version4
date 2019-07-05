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
@Table(name = "center")
public class Center {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CENTER")
	@SequenceGenerator(sequenceName = "seq_center", allocationSize = 1, name = "SEQ_CENTER")

	@Column(name = "centerId")
	public String centerId;

	@Column(name = "centerName")
	public String centerName;

	@OneToOne
	@Column(name = "id")
	public Address centerAddress;

	public Center() {
	};

	public Center(String centerId, String centerName, Address centerAddress) {
		super();
		this.centerId = centerId;
		this.centerName = centerName;
		this.centerAddress = centerAddress;
	}

	public String getCenterId() {
		return centerId;
	}

	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public Address getCenterAddress() {
		return centerAddress;
	}

	public void setCenterAddress(Address centerAddress) {
		this.centerAddress = centerAddress;
	}

	@Override
	public boolean equals(Object obj) {
		return this.centerId == ((Center) obj).centerId;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.centerId.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID: " + centerId + " Center Name: " + centerName + " Address: " + centerAddress;
	}

}