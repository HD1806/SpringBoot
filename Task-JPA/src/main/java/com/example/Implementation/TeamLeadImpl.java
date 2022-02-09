package com.example.Implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dto.TeamLeadDto;
import com.example.Model.SeniorModel;
import com.example.Model.TeamLeadModel;
import com.example.Repository.SeniorRepo;
import com.example.Repository.TeamLeadRepo;
import com.example.Repository.TraineeRepo;
import com.example.Service.TeamLeadService;

@Service
public class TeamLeadImpl implements TeamLeadService {
	
	@Autowired
	TeamLeadRepo tlrepo;
	
	@Autowired
	SeniorRepo srepo;
	
	@Autowired
	TraineeRepo trepo;
	
	@Override
	public TeamLeadModel save(TeamLeadDto dto) {
		
		SeniorModel model1=new SeniorModel();
		model1.setSid(dto.getSid());
		model1.setSname(dto.getSname());
		model1.setSrole(dto.getSrole());
		model1.setSphNo(dto.getSphNo());
		model1.setSaddress(dto.getSaddress());
		
		TeamLeadModel model=new TeamLeadModel();
		model.setId(dto.getId());
		model.setTLName(dto.getTLName());
		model.setRole(dto.getRole());
		model.setPhNo(dto.getPhNo());
		model.setAddress(dto.getAddress());
		model.getSeniormodel().add(model1);
		model1.setTlmodel(model);
		
		srepo.save(model1);
		
		return tlrepo.save(model);
	}

	@Override
	public TeamLeadModel update(TeamLeadDto dto) {
		TeamLeadModel update=tlrepo.findById(dto.getId()).get();
		
		SeniorModel upd=new SeniorModel();
		upd.setSid(dto.getSid());
		upd.setSname(dto.getSname());
		upd.setSrole(dto.getSrole());
		upd.setSaddress(dto.getSaddress());
		upd.setSphNo(dto.getSphNo());
		upd.setTlmodel(update);
		srepo.save(upd);
		return tlrepo.save(update);
	}

	@Override
	public TeamLeadModel addSen(TeamLeadDto dto) {
		TeamLeadModel addSen=tlrepo.findById(dto.getId()).get();
		
		SeniorModel add=new SeniorModel();
		add.setSid(dto.getSid());
		add.setSname(dto.getSname());
		add.setSrole(dto.getSrole());
		add.setSaddress(dto.getSaddress());
		add.setSphNo(dto.getSphNo());
		add.setTlmodel(addSen);
		srepo.save(add);
		return tlrepo.save(addSen);
	}

	@Override
	public List<TeamLeadModel> findAll() {
		List<TeamLeadModel> output=tlrepo.findAll();
		return output;
	}

	@Override
	public SeniorModel findById(TeamLeadDto dto) {
		
		SeniorModel get1=srepo.findById(dto.getSid()).get();
		return get1;
	}

	@Override
	public List<SeniorModel> findBySname(TeamLeadDto dto) {
	List<SeniorModel> get=srepo.findBySname(dto.getSname());
		return get;
	}

	@Override
	@Transactional
	public String deleteSid(int Sid) {
		
		srepo.deleteBySid(Sid);
		trepo.deleteByTid(Sid);
		
		return "success";
	}

}
