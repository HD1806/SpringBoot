package com.example.CS.ProImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CS.ProDto.Dto;
import com.example.CS.ProModel.Model;
import com.example.CS.ProRepo.Repo;
import com.example.CS.ProService.Service1;

@Service
public class Impl implements Service1 {

	@Autowired
	Repo repo;
	
	public String save(Dto dto) {
		Model model=new Model();
		model.setBname(dto.getBname());
		model.setLocation(dto.getLocation());
		model.setEcount(dto.getEcount());
		repo.save(model);
		return "success";
	}
	
	public List<Model> findAll(){
		List<Model> details=(List<Model>) repo.findAll();
		return details;
	}
	
	public String update(Dto dto) {
		Model model1=new Model();
		model1.setBname(dto.getBname());
		model1.setLocation(dto.getLocation());
		model1.setEcount(dto.getEcount());
		repo.save(model1);
		return "success";
	}
	
	public String deleteById(String cname) {
		repo.deleteById(cname);
		return "success";
	}

}
