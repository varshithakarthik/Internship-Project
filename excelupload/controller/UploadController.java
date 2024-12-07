package dev.fileupload.excelupload.controller;

import dev.fileupload.excelupload.service.UploadService;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
    private final UploadService uploadService;

    public UploadController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @RequestMapping(value = "/upload",
    		method = RequestMethod.POST,
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity upload(@RequestParam("file") MultipartFile file) throws Exception {
        String response = this.uploadService.upload(file);
        return  ResponseEntity.ok(response);
    }
}
