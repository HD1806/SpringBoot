package com.example.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dto.TeamLeadDto;
import com.example.Model.TraineeModel;
import com.example.Repository.TraineeRepo;
import com.example.Service.TraineeService;

@Service
public class TraineeImpl implements TraineeService {
	
	@Autowired
	TraineeRepo trepo;
	

	@Override
	public TraineeModel findByTid(TeamLeadDto dto) {
		TraineeModel get=trepo.findByTid(dto.getTid());
		
		return get;
	}

	@Override
	public TraineeModel update(TeamLeadDto dto) {
		TraineeModel upd=new TraineeModel();
		upd.setTid(dto.getTid());
		upd.setTname(dto.getTname());
		upd.setTrole(dto.getTrole());
		upd.setTaddress(dto.getTaddress());
		upd.setTphNo(dto.getTphNo());
		upd.setTask(dto.getTask());
		upd.setStatus(dto.getStatus());
		return trepo.save(upd);
	}

}
