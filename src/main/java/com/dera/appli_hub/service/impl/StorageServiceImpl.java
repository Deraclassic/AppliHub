package com.dera.appli_hub.service.impl;

import com.dera.appli_hub.domain.entity.FileData;
import com.dera.appli_hub.service.StorageService;
import com.dera.appli_hub.Utils.FileUtils;
import com.dera.appli_hub.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService {
    private final FileRepository fileRepository;
    @Override
    public String uploadFile(MultipartFile file) throws IOException {

        FileData fileData = FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(FileUtils.compressFile(file.getBytes()) )
                .build();

        fileRepository.save(fileData);
        return "File uploaded successfully";
    }

    @Override
    public byte[] downloadFile(String filename) {
        FileData fileData = fileRepository.findByName(filename)
                .orElseThrow(() -> new RuntimeException("Filename "+ filename +" not found"));

        byte[] file = FileUtils.decompressFile(fileData.getImageData()) ;
        return file;
    }

}
