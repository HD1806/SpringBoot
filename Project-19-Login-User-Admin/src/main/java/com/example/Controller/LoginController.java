package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dto.LoginDto;
import com.example.Model.LoginModel;
import com.example.Service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping(value="/create",produces="application/json")
	public String save(@RequestBody LoginDto loginDto) {
		String output=loginService.save(loginDto);
		return output;
	}
	
	@GetMapping(value="findby/{email}",produces="application/json")
	public List<LoginModel> findAllbyemail(@PathVariable("email") String email){
		return loginService.findAllByemail(email);
		
	}
	
	@PostMapping(value="check",produces="application/json")
	public String check(@RequestBody LoginDto loginDto) {
		String output=loginService.check(loginDto);
		return output;
	}
	
	@PutMapping(value="reset",produces="application/json")
	public String reset(@RequestBody LoginDto loginDto) {
		String output=loginService.forgetpassword(loginDto);
		return output;
	}

}
