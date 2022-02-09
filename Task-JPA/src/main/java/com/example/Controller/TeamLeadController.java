package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dto.TeamLeadDto;
import com.example.Model.SeniorModel;
import com.example.Model.TeamLeadModel;
import com.example.Service.TeamLeadService;

@RestController
public class TeamLeadController {
	
	@Autowired
	TeamLeadService service;
	
	@PostMapping(value="saveTl",produces = "application/json")
	public TeamLeadModel save(@RequestBody TeamLeadDto dto) {
		TeamLeadModel output=service.save(dto);
		return output;
	}
	
	@PostMapping(value="saveSeni",produces = "application/json")
	public TeamLeadModel addSen(@RequestBody TeamLeadDto dto) {
		TeamLeadModel output=service.addSen(dto);
		return output;
	}
	
	@PutMapping(value="updateSeni",produces = "application/json")
	public TeamLeadModel update(@RequestBody TeamLeadDto dto) {
		TeamLeadModel output=service.update(dto);
		return output;
	}
	
	@GetMapping(value="getAll",produces = "application/json")
	public List<TeamLeadModel> findAll() {
		List<TeamLeadModel> output=service.findAll();
		return output;
	}
	
	@GetMapping(value="getById",produces = "application/json")
	public SeniorModel findById(@RequestBody TeamLeadDto dto) {
		SeniorModel output=service.findById(dto);
		return output;
	}
	
	@GetMapping(value="getByName",produces = "application/json")
	public List<SeniorModel> findByName(@RequestBody TeamLeadDto dto) {
		List<SeniorModel> output=service.findBySname(dto);
		return output;
	}
	
	@DeleteMapping(value="/deleteById/{Sid}",produces="application/json")
	public String deleteSid(@PathVariable int Sid) {
		String output=service.deleteSid(Sid);
		return output;
	}

}
