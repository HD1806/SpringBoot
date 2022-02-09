package com.example.Repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Dto.TravelsDto;
import com.example.Model.DriverModel;
import com.example.Model.TravelsModel;

@Repository
public interface DriverRepo extends JpaRepository<DriverModel, Integer> {

	String save(TravelsModel gets);

	@Transactional
	@Modifying
	@Query("delete from DriverModel u WHERE u.dId=:dId")
	int deleteBydId(@Param("dId") int dId);

   DriverModel findBydId(int dId);	

}
