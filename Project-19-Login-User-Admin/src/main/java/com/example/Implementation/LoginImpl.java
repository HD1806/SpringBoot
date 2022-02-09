package com.example.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
//import org.springframework.ui.Model;

import com.example.Dto.LoginDto;
import com.example.Model.LoginModel;
import com.example.Repository.LoginRepo;
import com.example.Service.LoginService;

@Service
public class LoginImpl implements LoginService {

	@Autowired
	LoginRepo loginRepo;
	
	
	
	@Autowired
	PasswordEncoder encoder;
	
	@Bean
	PasswordEncoder getEncoder() {
	return new BCryptPasswordEncoder();
	}

	@Override
	public String save(LoginDto loginDto) {
		LoginModel model=new LoginModel();
		model.setId(loginDto.getId());
		model.setFirstname(loginDto.getFirstname());
		model.setLastname(loginDto.getLastname());
		model.setNumber(loginDto.getNumber());
		model.setEmail(loginDto.getEmail());
		model.setPassword(encoder.encode(loginDto.getPassword()));
		model.setRole(loginDto.getRole());
		loginRepo.save(model);
		return "success";
	}

	@Override
	public List<LoginModel> findAllByemail(String email) {
		return loginRepo.findAllByemail(email);
	}

	@Override
	public String check(LoginDto loginDto) {
		LoginModel model1=loginRepo.findByEmail(loginDto.getEmail());
		if(model1.getEmail().equalsIgnoreCase(loginDto.getEmail()) && loginDto.getPassword().equalsIgnoreCase(model1.getPassword())) 
		{
			model1.setLoginStatus("ACTIVE");
			loginRepo.save(model1);
			return "success done";
		}else {
		return "invalide";
		}
	}

	@Override
	public String forgetpassword(LoginDto loginDto) {
		LoginModel model2=loginRepo.findByEmail(loginDto.getEmail());
		model2.setPassword(encoder.encode(loginDto.getPassword()));
//		model2.setPassword(loginDto.getPassword());
		loginRepo.save(model2);
		return "update success";
	}

}
