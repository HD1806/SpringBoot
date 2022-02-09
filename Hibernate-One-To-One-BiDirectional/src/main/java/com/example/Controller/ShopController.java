package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dto.ShopDto;
import com.example.Entity.ShopEntity;
import com.example.Service.ShopService;

@RestController
public class ShopController {
	
	@Autowired
	ShopService service;
	
	@PostMapping(value="saveShop",produces = "application/json")
	public ShopEntity save(@RequestBody ShopDto shopdto) {
		ShopEntity output=service.save(shopdto);
		return output;
	}
	
	@GetMapping(value="getShop")
	public List<ShopEntity> findAll(){
		List<ShopEntity> output=service.findAll();
		return output;
	}
	
	@PutMapping(value="updateShop",produces = "application/json")
	public ShopEntity update(@RequestBody ShopDto shopdto) {
		ShopEntity output=service.update(shopdto);
		return output;
	}
	
	@DeleteMapping(value="delete/{id}",produces = "application/json")
	public String deleteByid(@PathVariable Integer id) {
		String output=service.deleteByid(id);
		return output;
	}

}
