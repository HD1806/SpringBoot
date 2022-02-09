package com.example.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Dto.LoginDto;
import com.example.Model.LoginModel;

@Service
public interface LoginService {

	String save(LoginDto loginDto);

	List<LoginModel> findAllByemail(String email);

	String check(LoginDto loginDto);

	String forgetpassword(LoginDto loginDto);

}
