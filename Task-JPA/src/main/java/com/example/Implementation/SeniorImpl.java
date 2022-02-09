package com.example.Implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dto.TeamLeadDto;
import com.example.Model.SeniorModel;
import com.example.Model.TraineeModel;
import com.example.Repository.SeniorRepo;
import com.example.Repository.TraineeRepo;
import com.example.Service.SeniorService;

@Service
public class SeniorImpl implements SeniorService {
	
	@Autowired
	SeniorRepo srepo;
	
	@Autowired
	TraineeRepo trepo;

	@Override
	public SeniorModel findBySid(TeamLeadDto dto) {
		SeniorModel get=srepo.findBySid(dto.getSid());
		return get;
	}


	@Override
	public SeniorModel savetra(TeamLeadDto dto) {
		SeniorModel smodel=srepo.findById(dto.getSid()).get();
		
		TraineeModel tmodel=new TraineeModel();
		tmodel.setTid(dto.getTid());
		tmodel.setTname(dto.getTname());
		tmodel.setTrole(dto.getTrole());
		tmodel.setTaddress(dto.getTaddress());
		tmodel.setTphNo(dto.getTphNo());
		tmodel.setTask(dto.getTask());
		tmodel.setStatus(dto.getStatus());
		
		smodel.getTraineemodel().add(tmodel);
		tmodel.getSeniormodel().add(smodel);
		
		trepo.save(tmodel);
		return srepo.save(smodel);
	}

	@Override
	public SeniorModel update(TeamLeadDto dto) {
		SeniorModel update=srepo.findById(dto.getSid()).get();
		
		TraineeModel upd=new TraineeModel();
		upd.setTid(dto.getTid());
		upd.setTname(dto.getTname());
		upd.setTrole(dto.getTrole());
		upd.setTaddress(dto.getTaddress());
		upd.setTphNo(dto.getTphNo());
		upd.setTask(dto.getTask());
		upd.setStatus(dto.getStatus());
		
		trepo.save(upd);
		return srepo.save(update);
	}

	@Override
	@Transactional
	public String deleteTid(int Tid) {
		trepo.deleteByTid(Tid);
		return "success";
	}

}
