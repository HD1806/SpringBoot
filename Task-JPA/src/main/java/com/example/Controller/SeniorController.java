package com.example.Controller;

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
import com.example.Service.SeniorService;

@RestController
public class SeniorController {
	
	@Autowired
	SeniorService Sservice;
	
	@GetMapping(value="findBySid",produces = "application/json")
	public SeniorModel findBySid(@RequestBody TeamLeadDto dto) {
		SeniorModel output=Sservice.findBySid(dto);
		return output;
	}
	
	@PostMapping(value="savetrain",produces = "application/json")
	public SeniorModel savetra(@RequestBody TeamLeadDto dto) {
		SeniorModel output=Sservice.savetra(dto);
		return output;
	}
	
	@PutMapping(value="updateTask",produces = "application/json")
	public SeniorModel update(@RequestBody TeamLeadDto dto) {
		SeniorModel output=Sservice.update(dto);
		return output;
	}
	
	@DeleteMapping(value="delete/{Tid}",produces = "application/json")
	public String deleteTid(@PathVariable int Tid) {
		String output=Sservice.deleteTid(Tid);
		return output;
	}
	
}
