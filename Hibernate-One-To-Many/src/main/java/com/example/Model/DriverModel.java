package com.example.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Driver_List")
public class DriverModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int dId;
	
	@Column(name="Employee_Name")
	private String dName;
	
	@Column(name="Driver_Address")
	private String dAddress;
	
	@ManyToOne()
	@JoinColumn(name="id",referencedColumnName = "id")
	@JsonIgnoreProperties("drive")
	private TravelsModel travelsmodel;

	public TravelsModel getTravelsmodel() {
		return travelsmodel;
	}

	public void setTravelsmodel(TravelsModel travelsmodel) {
		this.travelsmodel = travelsmodel;
	}

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getdAddress() {
		return dAddress;
	}

	public void setdAddress(String dAddress) {
		this.dAddress = dAddress;
	}

}
