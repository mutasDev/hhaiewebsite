package com.hhaie.backend.service.files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

@Service
public class StorageService {

    @Value("${spring.storagePath}")
    private String storagePath;

    public URL storeFile(MultipartFile file){
        UUID uuid = store(file);
        try {
            return new URL(uuid.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public UUID storeFileEntry(MultipartFile file) {
        UUID uuid = store(file);
        return uuid;
    }


    private UUID store(MultipartFile file) {
        UUID uuid = UUID.randomUUID();
        File outputFile = new File(uuid.toString() + "." + file.getOriginalFilename());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            fileOutputStream.write(file.getBytes());
            fileOutputStream.close();
        } catch ( IOException e) {
            e.printStackTrace();
        }
        return uuid;

    }

    public File load(String filepath) {
        File file = new File(storagePath + "/" + filepath);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  file;
    }

}
