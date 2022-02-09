package com.example.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.TravelsModel;

@Repository
public interface TravelsRepo extends JpaRepository<TravelsModel, Integer> {

	//TravelsModel findBydId(int getdId);

}
