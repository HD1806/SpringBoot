package com.example.CS.ProService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.CS.ProDto.Dto;
import com.example.CS.ProModel.Model;

@Service
public interface Service1 {
	
	String save(Dto dto);

	List<Model> findAll();

	String deleteById(String cname);

	String update(Dto dto);

}
