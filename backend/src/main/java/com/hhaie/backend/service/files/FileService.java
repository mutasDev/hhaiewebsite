package com.hhaie.backend.service.files;

import com.hhaie.backend.model.files.ExtendedResource;
import com.hhaie.backend.model.files.FileInfo;
import com.hhaie.backend.model.files.dto.FileInfoDto;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Optional;

@Service
public class FileService {

    private final FileInfoService fileInfoService;
    private final FileSystemFileStorageService storageService;


    @Autowired
    public FileService(FileInfoService fileInfoService, FileSystemFileStorageService storageService) {
        this.fileInfoService = fileInfoService;
        this.storageService = storageService;

    }

    public String save(@NonNull MultipartFile file, Long contextId) throws FileAlreadyExistsException {
        return this.save(file, contextId +"");
    }

    public String save(@NonNull MultipartFile file, String contextId) throws FileAlreadyExistsException{

        if(fileInfoService.isDuplicate(file.getOriginalFilename(), contextId)) {
            throw new FileAlreadyExistsException("");
        }

        FileInfo fileInfo = fileInfoService.createNewFileInfo(file, contextId);
        try {
            storageService.save(file, fileInfo.getId(), fileInfo.getContextId());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return fileInfo.getId();
    }


    public Optional<ExtendedResource> load(@NonNull String fileName, String context) {

        return fileInfoService.findByFileIdAndContext(fileName, context).map(fileInfo -> {

            ExtendedResource extendedResource = new ExtendedResource();
            extendedResource.setFileInfo(fileInfo);
            try {
                String filetype = fileInfo.getContentType().split("/")[1];
                extendedResource.setResource(storageService.load(fileInfo.getId(), fileInfo.getContextId()));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return extendedResource;
        });

    }

    public boolean delete(@NotNull String fileId, String context) {
        return fileInfoService.delete(fileId, context)
                && storageService.delete(fileId , context);
    }


    public FileInfoDto edit(MultipartFile file, String fileId, String contextId) throws FileNotFoundException {
        Optional<FileInfo> fileInfo = fileInfoService.findByFileIdAndContext(fileId, contextId);
        if(!fileInfo.isPresent()) {
            throw new FileNotFoundException("Die Datei wurde nicht gefunden.");
        }
        FileInfo finfo = fileInfo.get();
        storageService.delete(fileId, contextId);
        storageService.save(file, fileId, contextId);

        return fileInfoService.createDto(finfo);
    }



    public MultipartFile castWordToMultipart(File file) throws IOException {
        String type = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
        return  this.castToMultipart(file, type);
    }

    public MultipartFile castToMultipart(File file, String contentType) throws IOException {

        String name = file.getName();
        String originalFileName = file.getName();

        byte[] content = null;
        try {
            FileInputStream stream =  new FileInputStream(file);
            content =  stream.readAllBytes();
        } catch (final IOException e) {
            throw e;
        }
        MultipartFile result = new MockMultipartFile(name,
                originalFileName, contentType, content);
        return  result;
    }


}
