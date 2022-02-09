package com.example.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TraineeModel {
	
	@Id
	private int Tid;
	private String Tname;
	private String Trole;
	private long TphNo;
	private String Taddress;
	private String Task;
	private String Status;
	
	@ManyToMany
	@JoinTable(name="sid_tid",joinColumns = @JoinColumn(name="Tid"),
			inverseJoinColumns = @JoinColumn(name="Sid"))
	private List<SeniorModel> seniormodel=new ArrayList<>();
}
