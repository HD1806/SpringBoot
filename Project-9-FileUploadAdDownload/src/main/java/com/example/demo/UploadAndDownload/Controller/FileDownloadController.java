package com.example.demo.UploadAndDownload.Controller;

import java.io.FileNotFoundException;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.UploadAndDownload.Model.DataBaseFile;
import com.example.demo.UploadAndDownload.Service.DataBaseFileService;

@RestController
public class FileDownloadController {
	
	@Autowired
    private DataBaseFileService fileStorageService;

	@GetMapping("/downloadFile/{fileName:.+}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName, HttpServletRequest request) throws FileNotFoundException {
	// Load file as Resource
	DataBaseFile demoModel = fileStorageService.getFile(fileName);

	return ResponseEntity.ok()
	.contentType(MediaType.parseMediaType(demoModel.getFileType()))
	.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + demoModel.getFileName() + "\"")
	.body(new ByteArrayResource(demoModel.getData()));
	}
	
}
