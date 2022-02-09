package com.example.demo.UploadAndDownload.Service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.UploadAndDownload.Exception.FileStorageException;
import com.example.demo.UploadAndDownload.Model.DataBaseFile;
import com.example.demo.UploadAndDownload.Repository.DataBaseFileRepository;
import org.springframework.util.StringUtils;

@Service
public class DataBaseFileService {
	
	@Autowired
    private DataBaseFileRepository dbFileRepository;

	 public DataBaseFile storeFile(MultipartFile file) {
	        // Normalize file name
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	        try {
	            // Check if the file's name contains invalid characters
	            if (fileName.contains("..")) {
	                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
	            }

	           // DatabaseFile dbFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes());
	            DataBaseFile db=new DataBaseFile();
	            
	            db.setData(file.getBytes());
	            db.setFileName(fileName);
	            db.setFileType(file.getContentType());

	            return dbFileRepository.save(db);
	        } catch (IOException ex) {
	            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
	        }
	    }

	    public DataBaseFile getFile(String fileId) throws FileNotFoundException {
	        return dbFileRepository.findById(fileId)
	            .orElseThrow(()-> new FileNotFoundException("File not found with id " + fileId));
	    } 
	
}
