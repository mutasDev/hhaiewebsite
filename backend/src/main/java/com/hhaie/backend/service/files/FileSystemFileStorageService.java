package com.hhaie.backend.service.files;

import com.hhaie.backend.config.FileserviceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileSystemFileStorageService implements FileStorageService {
    private final Path root;


    @Autowired
    public FileSystemFileStorageService(FileserviceConfig config) {
        this.root = Paths.get(config.getFileDir());
    }



    @PostConstruct
    public void init() {
        try {
            createDirectoryIfNotExists(this.root);
        } catch (FileNotFoundException e) {
        }
    }


    private void createDirectoryIfNotExists(Path path) throws FileNotFoundException {
        try {
            if (!Files.exists(path)) {
                Files.createDirectory(path);
            }
        } catch (IOException e) {

            throw new FileNotFoundException("Verzeichnis konnte nicht angelegt werden.");
        }
    }


    public void save(MultipartFile file, String fileId, String contextId) throws FileNotFoundException {
        try {

            Path userPath = this.root.resolve(contextId);
            createDirectoryIfNotExists(userPath);
            Files.copy(file.getInputStream(), userPath.resolve(fileId));
        } catch (Exception e) {
            throw new FileNotFoundException("Die Datei konnte nicht gespeichert werden.");
        }
    }

    public Resource load(String fileId, String contextId) throws FileNotFoundException {
        try {
            Path file = root.resolve(contextId).resolve(fileId);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new FileNotFoundException("Die Datei " + file.toString() + " konnte nicht gelesen werden.");
            }
        } catch (MalformedURLException e) {
            throw new FileNotFoundException("Die Datei konnte nicht gelesen werden. Malformed URL.");
        }
    }


    public boolean delete(String filename, String context) {
        Path file = root.resolve(context).resolve(filename);
        try {
            Files.delete(file);
        } catch (IOException e) {

            return false;
        }
        return true;
    }
}
