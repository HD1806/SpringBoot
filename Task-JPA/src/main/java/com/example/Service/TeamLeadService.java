package com.example.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Dto.TeamLeadDto;
import com.example.Model.SeniorModel;
import com.example.Model.TeamLeadModel;

@Service
public interface TeamLeadService {

	TeamLeadModel save(TeamLeadDto dto);

	TeamLeadModel update(TeamLeadDto dto);

	TeamLeadModel addSen(TeamLeadDto dto);

	List<TeamLeadModel> findAll();

	SeniorModel findById(TeamLeadDto dto);

	List<SeniorModel> findBySname(TeamLeadDto dto);

	String deleteSid(int Sid);

}
