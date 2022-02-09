package com.example.Implementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dto.TravelsDto;
import com.example.Model.DriverModel;
import com.example.Model.TravelsModel;
import com.example.Repository.DriverRepo;
import com.example.Repository.TravelsRepo;
import com.example.Service.DriverService;

@Service
public class DriverImpl implements DriverService {
	
	@Autowired
	TravelsRepo travelsrepo;
	
	@Autowired
	DriverRepo driverrepo;

	@Override
	public DriverModel model(TravelsDto travelsdto) {
		DriverModel savedriv=new DriverModel();
		savedriv.setdName(travelsdto.getdName());
		savedriv.setdAddress(travelsdto.getdAddress());
		
		TravelsModel savetrav=new TravelsModel();
		savetrav.setId(travelsdto.getId());
		savetrav.setTname(travelsdto.getTname());
		savetrav.setAddress(travelsdto.getAddress());
		savetrav.getDrive().add(savedriv);
		savedriv.setTravelsmodel(savetrav);
		travelsrepo.save(savetrav);
		
		return driverrepo.save(savedriv);
	}

	@Override
	public DriverModel addDrive(TravelsDto travelsdto) {
		TravelsModel adddrv=travelsrepo.findById(travelsdto.getId()).get();
		
		DriverModel adddriv=new DriverModel();
		adddriv.setdId(travelsdto.getdId());
		adddriv.setdName(travelsdto.getdName());
		adddriv.setdAddress(travelsdto.getdAddress());
		adddriv.setTravelsmodel(adddrv);
		
		return driverrepo.save(adddriv);
	}

	@Override
	public DriverModel upDriv(TravelsDto travelsdto) {
		TravelsModel upd=travelsrepo.findById(travelsdto.getId()).get();
		
		DriverModel update=new DriverModel();
		update.setdId(travelsdto.getdId());
		update.setdName(travelsdto.getdName());
		update.setdAddress(travelsdto.getdAddress());
		update.setTravelsmodel(upd);
		
		return driverrepo.save(update);
	}

	@Override
	public List<DriverModel> findAll() {
		List<DriverModel> output=driverrepo.findAll();
		return output;
	}

	@Override
	public DriverModel findByid (TravelsDto travelsdto) {
		DriverModel gets=driverrepo.findBydId(travelsdto.getdId());
		return gets;
	}

	@Override
	public String deletedId(int dId) {
		driverrepo.deleteBydId(dId);
		return "succecc";
	}

}
