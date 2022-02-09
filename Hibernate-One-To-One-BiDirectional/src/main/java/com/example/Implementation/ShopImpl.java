package com.example.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dto.ShopDto;
import com.example.Entity.OwnerEntity;
import com.example.Entity.ShopEntity;
import com.example.Repo.OwnerRepo;
import com.example.Repo.ShopRepo;
import com.example.Service.ShopService;

@Service
public class ShopImpl implements ShopService {
	
	@Autowired
	OwnerRepo repo1;
	
	@Autowired
	ShopRepo repo2;

	@Override
	public ShopEntity save(ShopDto shopdto) {
		OwnerEntity owner=new OwnerEntity();
		owner.setOwnerName(shopdto.getOwnerName());
		owner.setOwnerAdd(shopdto.getOwnerAdd());
		owner=repo1.save(owner);
		
		ShopEntity shop=new ShopEntity();
		shop.setOwnerentity(owner);
		shop.setShopName(shopdto.getShopName());
		shop.setShopAdd(shopdto.getShopAdd());
		return repo2.save(shop);
	}

	@Override
	public List<ShopEntity> findAll() {
		List<ShopEntity> entity=repo2.findAll();
		return entity;
	}

	@Override
	public ShopEntity update(ShopDto shopdto) {
		OwnerEntity owner=new OwnerEntity();
		owner.setOwnerName(shopdto.getOwnerName());
		owner.setOwnerAdd(shopdto.getOwnerAdd());
		owner=repo1.save(owner);
		
		ShopEntity shop=repo2.findAllById(shopdto.getId());
		shop.setId(shopdto.getId());
		shop.setOwnerentity(owner);
		shop.setShopName(shopdto.getShopName());
		shop.setShopAdd(shopdto.getShopAdd());
		return repo2.save(shop);
	}

	@Override
	public String deleteByid(Integer id) {
		repo2.deleteById(id);
		return null;
	}

}
