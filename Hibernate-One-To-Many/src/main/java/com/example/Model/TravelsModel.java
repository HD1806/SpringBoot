package com.example.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Travels")
public class TravelsModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Travels_Name")
	private String Tname;
	
	private String Address;
	
	@OneToMany(targetEntity = DriverModel.class,mappedBy = "travelsmodel")
	@JsonIgnoreProperties("travelsmodel")
	private List<DriverModel> drive=new ArrayList<>();

	public List<DriverModel> getDrive() {
		return drive;
	}

	public void setDrive(List<DriverModel> drive) {
		this.drive = drive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTname() {
		return Tname;
	}

	public void setTname(String tname) {
		Tname = tname;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

}
