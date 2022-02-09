package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Model.LoginModel;

@Repository
public interface LoginRepo extends JpaRepository<LoginModel, Integer>{
	
	@Query("from LoginModel where email=:email")
	List<LoginModel> findAllByemail(@Param("email") String email);
	
//	@Query("from LoginModel where email=:email AND password=:password")
//	String check(@Param("email") String email)
	
	@Query("from LoginModel where email=:email")
	LoginModel findByEmail(@Param("email") String email);

}
