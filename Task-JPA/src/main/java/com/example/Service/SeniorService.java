package com.example.Service;

import org.springframework.stereotype.Service;

import com.example.Dto.TeamLeadDto;
import com.example.Model.SeniorModel;

@Service
public interface SeniorService {

	SeniorModel findBySid(TeamLeadDto dto);

	SeniorModel savetra(TeamLeadDto dto);

	SeniorModel update(TeamLeadDto dto);

	String deleteTid(int Tid);

}
