package com.hhaie.backend.controller;

import com.hhaie.backend.model.files.ExtendedResource;
import com.hhaie.backend.model.files.dto.FileInfoDto;
import com.hhaie.backend.service.files.FileInfoService;
import com.hhaie.backend.service.files.FileService;
import com.hhaie.backend.service.files.StorageService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("file")
public class FileController {

    private final FileInfoService fileInfoService;

    private final FileService storageService;


    public FileController(FileInfoService fileInfoService, FileService  storageService) {
        this.fileInfoService = fileInfoService;
        this.storageService = storageService;
    }

    @PostMapping(value = "/{contextId}")
    @CrossOrigin
    public ResponseEntity<String> submit(@RequestParam("file") MultipartFile file, @PathVariable String contextId) {
        String fileId = "";
        try {
            fileId = storageService.save(file, contextId);
        } catch (FileAlreadyExistsException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(fileId);
    }


    @PutMapping(value = "/variable/{variableId}")
    @CrossOrigin
    public FileInfoDto uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String variableId) throws FileNotFoundException, FileAlreadyExistsException {
        String fileId = "";
        fileId = storageService.save(file, variableId);
        return fileInfoService.getFileInfoById(fileId, variableId);
    }

    @PutMapping(value = "/thumbnail/")
    @CrossOrigin
    public FileInfoDto uploadFile(@RequestParam("file") MultipartFile file) throws FileNotFoundException, FileAlreadyExistsException {
        String fileId = "";
        fileId = storageService.save(file, "thumbnail");
        return fileInfoService.getFileInfoById(fileId, "thumbnail");
    }


    @GetMapping(value = "/{contextId}/{fileId}")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String fileId, @PathVariable String contextId) {
        Optional<ExtendedResource> optional = storageService.load(fileId, contextId);

        if (optional.isPresent()) {
            ExtendedResource extendedResource = optional.get();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + extendedResource.getFileInfo().getId() + "\"")
                    .header(HttpHeaders.CONTENT_TYPE, extendedResource.getFileInfo().getContentType())
                    .header(HttpHeaders.CONTENT_LENGTH, extendedResource.getFileInfo().getSize().toString())
                    .body(extendedResource.getResource());
        }

        return ResponseEntity.notFound().build();

    }

    @GetMapping(value = "/inline/{contextId}/{fileId}")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<Resource> getFileAsInline(@PathVariable String fileId, @PathVariable String contextId) {
        Optional<ExtendedResource> optional = storageService.load(fileId, contextId);
        if (optional.isPresent()) {
            ExtendedResource extendedResource = optional.get();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + extendedResource.getFileInfo().getId() + "\"")
                    .header(HttpHeaders.CONTENT_TYPE, extendedResource.getFileInfo().getContentType())
                    .header(HttpHeaders.CONTENT_LENGTH, extendedResource.getFileInfo().getSize().toString())
                    .body(extendedResource.getResource());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{contextId}/{fileId}")
    @CrossOrigin
    @ResponseBody
    public ResponseEntity<Boolean> deleteFile(@PathVariable String fileId, @PathVariable String contextId) {
        boolean ok = storageService.delete(fileId, contextId);
        return  ResponseEntity.ok(ok);
    }



    @GetMapping(value="/download/{contextId}/{fileId}")
    @CrossOrigin
    public  byte[] downloadFile(@PathVariable String fileId, @PathVariable String contextId) throws IOException {
        Optional<ExtendedResource> opt = storageService.load(fileId, contextId);
        if(opt.isPresent()) {
            Resource res = storageService.load(fileId, contextId).get().getResource();
            InputStreamResource resource = new InputStreamResource((new FileInputStream(res.getFile())));
            InputStream is = resource.getInputStream();
            return is.readAllBytes();
        } else {
            throw new NoSuchElementException("Es wurde kein Element zu diesem Kontext und ID gefunden.");
        }
    }
}
