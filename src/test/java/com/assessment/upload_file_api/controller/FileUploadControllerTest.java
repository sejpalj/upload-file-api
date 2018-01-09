package com.assessment.upload_file_api.controller;

import com.assessment.upload_file_api.entity.MetaDataBean;
import com.assessment.upload_file_api.service.FileUploadStorageProperties;
import com.assessment.upload_file_api.service.MetaDataService;
import com.assessment.upload_file_api.service.StorageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FileUploadController.class)
public class FileUploadControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StorageService storageService;

    @MockBean
    private MetaDataService metaDataService;

    @MockBean
    private FileUploadStorageProperties fileUploadStorageProperties;

    @Test
    public void shouldSaveUploadedFile() throws Exception {
        final MockMultipartFile multipartFile = new MockMultipartFile("file", "abc.txt",
                "text/plain", "Test".getBytes());
        given(this.fileUploadStorageProperties.getLocation()).willReturn("target");
        this.mvc.perform(fileUpload("/api/upload").file(multipartFile))
                .andExpect(status().isOk());

        then(this.storageService).should().store(multipartFile);
        then(this.metaDataService).should().saveMetaData(any(MetaDataBean.class));
    }
}
