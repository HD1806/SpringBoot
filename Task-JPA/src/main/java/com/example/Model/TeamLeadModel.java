package com.example.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter


public class TeamLeadModel {
	
	@Id
	private int id;
	private String TLName;
	
	private String Role;
	private long PhNo;
	
	private String Address;
	
	@OneToMany(targetEntity = SeniorModel.class,mappedBy = "tlmodel")
	@JsonIgnoreProperties("tlmodel")
	private List<SeniorModel> seniormodel=new ArrayList<>();
	
}
