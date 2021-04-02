package com.hhaie.backend.controller;

import com.hhaie.backend.service.files.FileInfoService;
import com.hhaie.backend.service.files.FileService;
import com.hhaie.backend.service.files.StorageService;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/files")
public class FileController {

    private final FileInfoService fileInfoService;

    private final FileService fileService;

    private final StorageService storageService;


    public FileController(FileInfoService fileInfoService, FileService fileService, StorageService storageService) {
        this.fileInfoService = fileInfoService;
        this.fileService = fileService;
        this.storageService = storageService;
    }
}
