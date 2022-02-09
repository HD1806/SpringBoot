package com.example.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dto.OwnerDto;
import com.example.Entity.OwnerEntity;
import com.example.Entity.ShopEntity;
import com.example.Repo.OwnerRepo;
import com.example.Repo.ShopRepo;
import com.example.Service.OwnerService;

@Service
public class OwnerImpl implements OwnerService {
	
	@Autowired
	OwnerRepo repo1;
	
	@Autowired
	ShopRepo repo2;

	@Override
	public OwnerEntity getowner(OwnerDto ownerdto) {
		ShopEntity shop=new ShopEntity();
		shop.setShopName(ownerdto.getShopName());
		shop.setShopAdd(ownerdto.getShopAdd());
		
		OwnerEntity owner=new OwnerEntity();
		owner.setShopentity(shop);
		owner.setOwnerName(ownerdto.getOwnerName());
		owner.setOwnerAdd(ownerdto.getOwnerAdd());
		shop.setOwnerentity(owner);
		shop=repo2.save(shop);
		
		return repo1.save(owner);
	}

}
