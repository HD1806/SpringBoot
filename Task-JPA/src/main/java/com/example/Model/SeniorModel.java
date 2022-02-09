package com.example.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SeniorModel {
	
	@Id
	private int Sid;
	private String Sname;
	private String Srole;
	private long SphNo;
	private String Saddress;
	
	@ManyToOne
	@JoinColumn(name="Id",referencedColumnName = "Id")
	@JsonIgnoreProperties("seniormodel")
	private  TeamLeadModel tlmodel;
	
	@ManyToMany(mappedBy = "seniormodel")
	@JsonIgnoreProperties("seniormodel")
	private List<TraineeModel> traineemodel=new ArrayList<>();
	
	}


