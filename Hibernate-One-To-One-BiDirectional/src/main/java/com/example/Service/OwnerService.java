package com.example.Service;

import org.springframework.stereotype.Service;

import com.example.Dto.OwnerDto;
import com.example.Entity.OwnerEntity;

@Service
public interface OwnerService {

	OwnerEntity getowner(OwnerDto ownerdto);

}
