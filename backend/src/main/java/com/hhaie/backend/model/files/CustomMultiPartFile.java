package com.hhaie.backend.model.files;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

public class CustomMultiPartFile implements MultipartFile {


    private final byte[] fileContent;
    private File file;
    private String fileName;
    private String contentType;
    private FileOutputStream fileOutputStream;
    private final String destPath = System.getProperty("java.io.tmpdir");

    public CustomMultiPartFile(byte[] byteArray) {
        fileContent = byteArray;
        fileName = UUID.randomUUID().toString();
        file = new File(destPath + fileName);
    }

    public CustomMultiPartFile(byte[] byteArray, String fileName) {
        this(byteArray);
        this.fileName = fileName;
    }

    @Override
    public String getName() {
        return fileName;
    }

    @Override
    public String getOriginalFilename() {
        return fileName;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public boolean isEmpty() {
        return fileContent == null || fileContent.length == 0;
    }

    @Override
    public long getSize() {
        long size = 0;
        if (fileContent != null) {
            size = fileContent.length;
        }
        return size;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return fileContent;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(fileContent);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        fileOutputStream = new FileOutputStream(dest);
        fileOutputStream.write(fileContent);
    }

    public void clearOutStreams() throws IOException {
        if (fileOutputStream != null) {
            fileOutputStream.flush();
            fileOutputStream.close();
            file.deleteOnExit();
        }
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}