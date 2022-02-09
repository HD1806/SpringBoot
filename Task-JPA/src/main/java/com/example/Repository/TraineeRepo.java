package com.example.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Model.TraineeModel;

@Repository
public interface TraineeRepo extends JpaRepository<TraineeModel, Integer> {

	@Query("from TraineeModel u where u.Tid=:Tid")
	TraineeModel findByTid(@Param("Tid") int Tid);

	@Transactional
	@Modifying
	@Query("delete from TraineeModel b where b.Tid=:Tid")
	void deleteByTid(@Param("Tid") int Tid);

}
