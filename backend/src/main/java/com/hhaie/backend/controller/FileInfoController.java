package com.hhaie.backend.controller;

import com.hhaie.backend.model.files.FileInfo;
import com.hhaie.backend.model.files.dto.FileInfoDto;
import com.hhaie.backend.service.files.FileInfoService;
import com.hhaie.backend.service.files.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/fileinfo")
public class FileInfoController {

    private final FileService fileService;

    private final FileInfoService fileInfoService;


    @Autowired
    public FileInfoController(FileService fileService, FileInfoService fileInfoService) {
        this.fileService = fileService;
        this.fileInfoService = fileInfoService;

    }


    @GetMapping(value = "")
    @CrossOrigin
    public ResponseEntity<Collection<FileInfoDto>> list() {
        return ResponseEntity.ok(fileInfoService.listAll());
    }

    @GetMapping(value = "/{contextId}/{fileId}")
    @CrossOrigin
    public ResponseEntity<FileInfo> getFileInfo(@PathVariable String fileId, @PathVariable String contextId) {
        Optional<FileInfo> optional = fileInfoService.findByFileIdAndContext(fileId, contextId);
        return optional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping(value = "/{contextId}/{fileId}")
    @CrossOrigin
    public ResponseEntity<Void> delete(@PathVariable String fileId, @PathVariable String contextId) {
        return (fileService.delete(fileId, contextId) ? ResponseEntity.ok() : ResponseEntity.notFound()).build();
    }


    @PutMapping(value = "/entity/{contextId}")
    @CrossOrigin
    public ResponseEntity<List<FileInfoDto>> getFileInfoOfSpecifiedFiles(@PathVariable String contextId, @RequestBody List<String> fileIds) {
        return ResponseEntity.ok(fileInfoService.getFileInfosForIds(fileIds, contextId));
    }

    @GetMapping(value = "/{contextId}")
    @CrossOrigin
    public ResponseEntity<List<FileInfoDto>> getFileInfosOfContext(@PathVariable String contextId) {
        return ResponseEntity.ok(fileInfoService.getFileInfosForContext(contextId));
    }


    @PostMapping(value = "/{contextId}/{fileInfoId}")
    @CrossOrigin
    public ResponseEntity<FileInfoDto> editFileInfo(@PathVariable String fileInfoId, @PathVariable String contextId,
                                                    @RequestBody FileInfoDto dto) {
        try {
            return ResponseEntity.ok(fileInfoService.editFileInfo(fileInfoId, contextId, dto));
        } catch (FileNotFoundException e) {
            return (ResponseEntity<FileInfoDto>) ResponseEntity.ok();
        }
    }

}