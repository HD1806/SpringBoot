package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Model.TeamLeadModel;

@Repository
public interface TeamLeadRepo extends JpaRepository<TeamLeadModel, Integer> {

}
