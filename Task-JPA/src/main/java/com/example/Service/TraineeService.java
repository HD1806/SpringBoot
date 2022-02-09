package com.example.Service;

import org.springframework.stereotype.Service;

import com.example.Dto.TeamLeadDto;
import com.example.Model.TraineeModel;

@Service
public interface TraineeService {

	TraineeModel findByTid(TeamLeadDto dto);

	TraineeModel update(TeamLeadDto dto);

}
