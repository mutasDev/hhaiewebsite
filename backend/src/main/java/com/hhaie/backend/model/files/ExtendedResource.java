package com.hhaie.backend.model.files;

import org.springframework.core.io.Resource;

public class ExtendedResource {

    private FileInfo fileInfo;
    private Resource resource;

    public FileInfo getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(FileInfo fileInfo) {
        this.fileInfo = fileInfo;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}