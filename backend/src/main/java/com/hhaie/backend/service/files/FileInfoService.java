package com.hhaie.backend.service.files;

import com.hhaie.backend.config.FileserviceConfig;
import com.hhaie.backend.model.files.FileInfo;
import com.hhaie.backend.model.files.dto.FileInfoDto;
import com.hhaie.backend.repository.FileInfoRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FileInfoService {

    private final FileserviceConfig config;
    private final FileInfoRepository repository;


    @Autowired
    public FileInfoService(FileserviceConfig config,  FileInfoRepository repository) {
        this.config = config;
        this.repository = repository;
    }



    public FileInfo createNewFileInfo(@NonNull MultipartFile file, String contextId) {

        FileInfo info = new FileInfo();
        info.setId(UUID.randomUUID().toString());
        info.setFilename(file.getOriginalFilename());
        info.setContentType(file.getContentType());
        info.setSize(file.getSize());
        info.setContextId(contextId);

        repository.save(info);

        return info;
    }

    public FileInfo createNewFileInfo(@NonNull MultipartFile file,  String contextId, String fileName) {
        FileInfo info = this.createNewFileInfo(file, contextId);
        info.setFilename(fileName);
        return  info;
    }


    public Collection<FileInfoDto> listAll() {
        List<FileInfo> infoList = repository.findAll();
        return infoList.stream().map(this::createDto).collect(Collectors.toList());
    }


    FileInfoDto createDto(FileInfo fileInfo) {
        FileInfoDto dto = new FileInfoDto();
        dto.setId(fileInfo.getId());
        dto.setContentType(fileInfo.getContentType());
        dto.setFilename(fileInfo.getFilename());
        dto.setSize(fileInfo.getSize());
        dto.setDescription(fileInfo.getDescription());
        dto.setUrl(config.getBaseUrl() + "file/" + fileInfo.getId());

        return dto;
    }



    public Optional<FileInfo> findByFileIdAndContext(@NonNull String fileId, String contextId) {
        return repository.findByIdAndContextId(fileId,contextId );
    }


    public boolean isDuplicate(String fileId, String contextId) {
        return  repository.findByIdAndContextId(fileId,contextId ).isPresent();
    }

    public boolean delete(@NonNull String fileId, String contextId) {
        Optional<FileInfo> fileInfo = repository.findByIdAndContextId(fileId, contextId);
        if (fileInfo.isPresent()) {
            repository.deleteById(fileInfo.get().getId());
            return true;
        }
        return false;
    }

    public List<FileInfoDto> getFileInfosForIds(List<String> fileIds, String contextId) {
        List<FileInfo> fileInfos = this.repository.findAllByIdInAndContextId(fileIds, contextId);
        return fileInfos.stream().map(this::createDto).collect(Collectors.toList());
    }

    public FileInfoDto getFileInfoById(@NonNull String fileInfoId, String contextId) throws FileNotFoundException {
        Optional<FileInfo> fileInfo = findByFileIdAndContext(fileInfoId,contextId);
        if (fileInfo.isPresent()) {
            FileInfoDto fileInfoDto = createDto(fileInfo.get());
            return (fileInfoDto);
        } else {
            throw new FileNotFoundException("test");
        }
    }

    public FileInfo save(FileInfo finfo) {
        repository.save(finfo);
        return finfo;
    }



    public FileInfoDto editFileInfo(String fileInfoId, String contextId, FileInfoDto dto) throws FileNotFoundException {
        Optional<FileInfo> fileInfo = findByFileIdAndContext(fileInfoId, contextId);
        if (fileInfo.isPresent()) {
            FileInfo finfo = fileInfo.get();
            finfo.setDescription(dto.getDescription());
            finfo.setFilename(dto.getFilename());
            repository.save(finfo);
            return createDto(finfo);
        } else {
            throw new FileNotFoundException("Die Datei wurde nicht gefunden.");
        }

    }

    public List<FileInfoDto> getFileInfosForContext(String contextId) {
        List<FileInfo> all = this.repository.findAll();
        List<FileInfo> fileInfos = this.repository.findAllByContextId(contextId);
        return fileInfos.stream().map(this::createDto).collect(Collectors.toList());
    }
}
