package com.example.CS.ProController;

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

import com.example.CS.ProDto.Dto;
import com.example.CS.ProModel.Model;
import com.example.CS.ProService.Service1;

@RestController
//@RequestMapping("/api")
public class Controller {
	
	@Autowired
	Service1 service;
	
	@PostMapping(value="/create",produces="application/json")
	public String save(@RequestBody Dto dto) throws Exception{
		try {
			String output=service.save(dto);
			return output;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	@GetMapping(value="/read",produces="application/json")
	public List<Model> read() throws Exception{
		try {
			List<Model> output=service.findAll();
			return output;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping(value="/update",produces="application/json")
	public String update(@RequestBody Dto dto) throws Exception{
		try {
			String output=service.update(dto);
			return output;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	@DeleteMapping(value="/delete/{cname}",produces="application/json")
	public String delete(@PathVariable String cname) {
		try {
			String output=service.deleteById(cname);
			return output;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
