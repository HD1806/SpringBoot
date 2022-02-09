package com.example.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Model.SeniorModel;

@Repository
public interface SeniorRepo extends JpaRepository<SeniorModel, Integer> {

	@Query("from SeniorModel u where u.Sname=:Sname")
	List<SeniorModel> findBySname(@Param("Sname") String sname);


	@Transactional
	@Modifying
	@Query("delete from SeniorModel b where b.Sid=:Sid")
	int deleteBySid(@Param("Sid") int Sid);


	@Query("from SeniorModel u where u.Sid=:Sid")
	SeniorModel findBySid(@Param("Sid") int Sid);

}
