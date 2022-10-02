package com.ticketapp.sfmoviehouse.controller;

import com.ticketapp.sfmoviehouse.dto.response.ResponseMessage;
import com.ticketapp.sfmoviehouse.dto.response.ResponseFile;
import com.ticketapp.sfmoviehouse.model.File;
import com.ticketapp.sfmoviehouse.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileController {

    private FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            fileService.store(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = fileService.getAllFiles().map(File -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(File.getId())
                    .toUriString();

            return new ResponseFile(
                    File.getName(),
                    fileDownloadUri,
                    File.getType(),
                    File.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        File file = fileService.getFile(Long.valueOf(id));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(file.getData());
    }
}