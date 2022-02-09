package com.example.demo.UploadAndDownload.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.UploadAndDownload.Model.DataBaseFile;

@Repository
public interface DataBaseFileRepository extends JpaRepository<DataBaseFile, String> {
	
	
}
