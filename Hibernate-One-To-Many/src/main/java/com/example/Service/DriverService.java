package com.example.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Dto.TravelsDto;
import com.example.Model.DriverModel;
import com.example.Model.TravelsModel;

@Service
public interface DriverService {

	DriverModel model(TravelsDto travelsdto);

	DriverModel addDrive(TravelsDto travelsdto);

	DriverModel upDriv(TravelsDto travelsdto);

	List<DriverModel> findAll();

	String deletedId(int dId);

	DriverModel findByid(TravelsDto travelsdto);

}
