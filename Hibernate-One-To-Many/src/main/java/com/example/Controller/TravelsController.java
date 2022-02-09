package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dto.TravelsDto;
import com.example.Model.DriverModel;
import com.example.Model.TravelsModel;
import com.example.Service.DriverService;

@RestController
public class TravelsController {
	
	@Autowired
	DriverService driverservice;
	
	@PostMapping(value="/mapSave",produces = "application/json")
	public DriverModel model(@RequestBody TravelsDto travelsdto ) {
		DriverModel output=driverservice.model(travelsdto);
		return output;
	}
	
	@PostMapping(value="/mapdriv",produces = "application/json")
	public DriverModel addDriv(@RequestBody TravelsDto travelsdto) {
		DriverModel output=driverservice.addDrive(travelsdto);
		return output;
	}
	
	@GetMapping(value="/getAll",produces = "application/json")
	public List<DriverModel> findAll(){
		List<DriverModel> output=driverservice.findAll();
		return output;
		
	}
	
	@GetMapping(value="/getById",produces = "application/json")
	public DriverModel findBydId(@RequestBody TravelsDto travelsdto) {
		DriverModel output=driverservice.findByid(travelsdto);
		return output;
	}
	
	@PutMapping(value="/updriv",produces = "application/json")
	public DriverModel upDriv(@RequestBody TravelsDto travelsdto) {
		DriverModel output=driverservice.upDriv(travelsdto);
		return output;
	}
	
	@DeleteMapping(value="/delete/{dId}",produces = "application/json")
	public String deletedId(@PathVariable int dId) {
		String output=driverservice.deletedId(dId);
		return output;
	}
	
}
