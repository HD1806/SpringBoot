package com.example.demo.serviceiml;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponse {
	
	private String Message;
	private int status;
	private Object response;
	
	
	public MessageResponse(String kkk, int status) {
		super();
		this.Message = kkk;
		this.status = status;
	}
	
	public MessageResponse(String kkk, int status, Object response) {
		super();
		this.Message = kkk;
		this.status = status;
		this.response = response;
	}
	

}
