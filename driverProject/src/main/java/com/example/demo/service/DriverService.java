package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DriverDto;
import com.example.demo.model.DriverModel;
import com.example.demo.serviceiml.MessageResponse;


@Service
public interface DriverService {
	
	
	String save (DriverDto driverdto);
	
	
	ResponseEntity<MessageResponse> update(DriverDto driverdto);
	
	String delete(int id);
	
	List<DriverModel>findAll();
	

}
