package com.example.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.ShopEntity;

@Repository
public interface ShopRepo extends JpaRepository<ShopEntity, Integer> {

	ShopEntity findAllById(int id);

}
