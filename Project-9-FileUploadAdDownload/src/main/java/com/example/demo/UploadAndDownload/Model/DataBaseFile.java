package com.example.demo.UploadAndDownload.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "files")
public class DataBaseFile {
	    @Id
	    @GeneratedValue(generator = "uuid")
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    private String id;

	    private String fileName;

	    private String fileType;

	    @Lob
	    private byte[] data;

	    public DataBaseFile() {

	    }

	    public DataBaseFile(String fileName, String fileType, byte[] data) {
	        this.fileName = fileName;
	        this.fileType = fileType;
	        this.data = data;
	    }

	    public String getId() {
	        return id;
	    }

	    public String getFileName() {
	        return fileName;
	    }

	    public String getFileType() {
	        return fileType;
	    }

	    public byte[] getData() {
	        return data;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public void setFileName(String fileName) {
	        this.fileName = fileName;
	    }

	    public void setFileType(String fileType) {
	        this.fileType = fileType;
	    }

	    public void setData(byte[] data) {
	        this.data = data;
	    }

	
	    
	}
	

