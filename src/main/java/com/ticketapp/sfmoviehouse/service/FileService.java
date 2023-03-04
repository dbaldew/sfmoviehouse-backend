package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.entity.File;
import com.ticketapp.sfmoviehouse.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class FileService {

    @Autowired
    private final FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public File store (MultipartFile file) throws IOException{
        String fileName = StringUtils.cleanPath((Objects.requireNonNull(file.getOriginalFilename())));
        File File = new File(fileName, file.getContentType(), file.getBytes());
        return fileRepository.save(File);
    }

    public File getFile(String id){
        return fileRepository.findById(id).get();
    }

    public Stream<File> getAllFiles(){
        return fileRepository.findAll().stream();

    }





}
