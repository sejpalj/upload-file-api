package com.assessment.upload_file_api.controller;

import com.assessment.upload_file_api.entity.MetaDataBean;
import com.assessment.upload_file_api.service.FileUploadStorageProperties;
import com.assessment.upload_file_api.service.MetaDataService;
import com.assessment.upload_file_api.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
public class FileUploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);

    private final StorageService storageService;

    private final MetaDataService metaDataService;

    private final FileUploadStorageProperties fileUploadStorageProperties;

    @Autowired
    public FileUploadController(final StorageService storageService, final MetaDataService metaDataService, final FileUploadStorageProperties fileUploadStorageProperties) {
        this.storageService = storageService;
        this.metaDataService = metaDataService;
        this.fileUploadStorageProperties = fileUploadStorageProperties;
    }

    @PostMapping
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {

        LOGGER.info(file.getOriginalFilename());
        storageService.store(file);
        metaDataService.saveMetaData(new MetaDataBean(file.getOriginalFilename(), fileUploadStorageProperties.getLocation().concat("/").concat(file.getOriginalFilename()), file.getContentType()));
        return new ResponseEntity<String>(file.getName(), HttpStatus.OK);
    }

}
