package com.example.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Login_Details")
@Data
public class LoginModel {
	
	@Id
	@GeneratedValue
	private int id;
	private String firstname;
	private String lastname;
	private long number;
	private String email;
	private String password;
	private String role;
	private String loginStatus;

}
