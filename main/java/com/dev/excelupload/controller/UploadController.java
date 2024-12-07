package dev.mj.excelupload.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import dev.mj.excelupload.service.UploadService;

@RestController
public class UploadController {
	private final UploadService uploadService;
	
	public UploadController(UploadService uploadService){
		this.uploadService = uploadService;
	}
	
	@PostMapping("/upload")
	public void upload(@RequestParam("file") MultipartFile file){
		try {
			uploadService.upload(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
