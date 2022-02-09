package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dto.TeamLeadDto;
import com.example.Model.TraineeModel;
import com.example.Service.TraineeService;

@RestController
public class TraineeController {
	
	@Autowired
	TraineeService tservice;
	
	@GetMapping(value="getByTid",produces = "application/json")
	public TraineeModel findByTid(@RequestBody TeamLeadDto dto) {
		TraineeModel output=tservice.findByTid(dto);
		return output;
	}
	
	@PutMapping(value="update",produces = "application/json")
	public TraineeModel update(@RequestBody TeamLeadDto dto) {
		TraineeModel output=tservice.update(dto);
		return output;
	}

}
