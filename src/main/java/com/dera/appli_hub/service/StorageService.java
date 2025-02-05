package com.dera.appli_hub.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageService {

    String uploadFile(MultipartFile file) throws IOException;
    byte[] downloadFile(String filename);
}
