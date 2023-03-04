package com.ticketapp.sfmoviehouse.controller;

import com.ticketapp.sfmoviehouse.entity.File;
import com.ticketapp.sfmoviehouse.message.FileResponseMessage;
import com.ticketapp.sfmoviehouse.message.ResponseFile;
import com.ticketapp.sfmoviehouse.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;
//credit to Bezkoder at https://www.bezkoder.com/spring-boot-upload-file-database/

@Controller
public class FileController {

    @Autowired
    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

     @PostMapping("/upload")
    public ResponseEntity<FileResponseMessage> uploadFile(@RequestParam("file")MultipartFile file){
        String message = "";
        try{
            fileService.store(file);
            message = "File upload success: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new FileResponseMessage(message));
        }catch (Exception e){
            message = "File upload failed: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileResponseMessage(message));
        }
     }

     @GetMapping("files")
    public ResponseEntity<List<ResponseFile>> getListOfFiles(){
        List<ResponseFile> files = fileService.getAllFiles().map(file -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files")
                    .path(String.valueOf(file.getId()))
                    .toUriString();

            return new ResponseFile(
                    file.getName(),
                    fileDownloadUri,
                    file.getType(),
                    (long) file.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
     }

     @GetMapping("files/{id")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id){
        File file = fileService.getFile(String.valueOf(id));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename = \"" + file.getName() + "\"")
                .body(file.getData());
     }

}
