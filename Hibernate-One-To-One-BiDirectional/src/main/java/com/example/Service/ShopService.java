package com.example.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Dto.ShopDto;
import com.example.Entity.ShopEntity;

@Service
public interface ShopService {

	ShopEntity save(ShopDto shopdto);

	List<ShopEntity> findAll();

	ShopEntity update(ShopDto shopdto);

	String deleteByid(Integer id);

}
