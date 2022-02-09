package com.example.Dto;

import lombok.Data;

@Data
public class LoginDto {
	
	private int id;
	private String firstname;
	private String lastname;
	private long number;
	private String email;
	private String password;
	private String role;
	private String loginStatus;

}
