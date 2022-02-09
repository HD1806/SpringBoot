package com.example.CS.ProRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.CS.ProModel.Model;

@Repository
public interface Repo extends CrudRepository<Model, String> {

}
