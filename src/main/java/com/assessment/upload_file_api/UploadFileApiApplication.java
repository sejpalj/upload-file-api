package com.assessment.upload_file_api;

import com.assessment.upload_file_api.service.FileUploadStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


//Just to test git if its working or not yoloyolyoyoylyoylyol
// this is my name jatin
// this is sanjay
//before merge
@SpringBootApplication
@EnableConfigurationProperties(FileUploadStorageProperties.class)
public class UploadFileApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadFileApiApplication.class, args);
	}
}
