package com.example.demo.serviceiml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.example.demo.dto.DriverDto;
import com.example.demo.model.DriverModel;
import com.example.demo.repo.DriverRepo;
import com.example.demo.service.DriverService;


@Service
public class DriverServiceIml implements DriverService{
	
	@Autowired
	Environment env;
	
	@Autowired
	DriverRepo driverrepo;
	
	
	
	@Autowired
	PasswordEncoder encode;
	
	@Override
	public String save(DriverDto driverdto) {
		
		DriverModel model=DriverModel.builder().id(driverdto.getId())
				.drivername(driverdto.getDrivername())
				.location(driverdto.getLocation()).password(encode.encode(driverdto.getPassword()))
				.salary(driverdto.getSalary()).gender(driverdto.getGender())
				.build();
		driverrepo.save(model);

		
		return "suceessflly";
	}

	//@SuppressWarnings("static-access")
	@Override
	public ResponseEntity<MessageResponse>  update(DriverDto driverdto) {
		
		try {
		DriverModel obj=driverrepo.findById(driverdto.getId()).get();
		DriverModel obj1=DriverModel.builder().id(driverdto.getId()).drivername(driverdto.getDrivername())
		.location(driverdto.getLocation()).salary(driverdto.getSalary())
		.password(encode.encode(driverdto.getPassword()))
		.gender(driverdto.getGender()).build();
		obj1 = driverrepo.save(obj1);
		return ResponseEntity.ok(new MessageResponse("success",HttpStatus.OK.value(),obj1));
		}
		catch(Exception e) {
					
			return ResponseEntity.ok(new MessageResponse(env.getProperty("errorid"),HttpStatus.BAD_REQUEST.value()));

		}
	    

	}

	@Override
	public String delete(int id) {
		driverrepo.deleteById(id);
		return "delete sucessfully..";
	}

	@Override
	public List<DriverModel> findAll() {
		List<DriverModel>model2=(List<DriverModel>)driverrepo.findAll();
		return model2;
	}

}
