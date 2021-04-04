package com.hhaie.backend.service.files;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

@Service
public interface FileStorageService {

    void save(MultipartFile file, String fileId, String context) throws FileNotFoundException;

    Resource load(String fileId, String context) throws FileNotFoundException;

    boolean delete(String fileId, String context);
}