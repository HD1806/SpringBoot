package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dto.OwnerDto;
import com.example.Entity.OwnerEntity;
import com.example.Service.OwnerService;

@RestController
public class OwnerController {
	
	@Autowired
	OwnerService service;
	
	@PostMapping(value="/saveOwner",produces = "application/json")
	public OwnerEntity getOwner(@RequestBody OwnerDto ownerdto ) {
		OwnerEntity output=(OwnerEntity) service.getowner(ownerdto);
		return output;
	}

}
