package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DriverDto;
import com.example.demo.model.DriverModel;
import com.example.demo.service.DriverService;
import com.example.demo.serviceiml.MessageResponse;

@RestController

public class DriverController {

	@Autowired
	DriverService driverservice;
	
	
	@PostMapping(value="/save123",produces="application/json")
	public String save(@RequestBody DriverDto driverdto) {
		String output=driverservice.save(driverdto);
		return output;
	}
	
	@GetMapping(value="/findall",produces="application/json")
	public List<DriverModel>findAll(){
		List<DriverModel>output=driverservice.findAll();
		return output;
	}
	
	@DeleteMapping(value="/delete/{id}",produces="application/json")
	public String delete(@PathVariable int id) {
		String output=driverservice.delete(id);
		return output;
	}
	@PutMapping(value="/update",produces="application/json")
	public ResponseEntity<MessageResponse> update(@RequestBody DriverDto driverdto) {
		ResponseEntity<MessageResponse> output=driverservice.update(driverdto);
		return output;
	}
	
}
