package com.assessment.upload_file_api.service;

import com.assessment.upload_file_api.repository.MetaDataRepository;
import com.assessment.upload_file_api.entity.MetaDataBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetaDataServiceImpl implements MetaDataService {

    private final MetaDataRepository metaDataRepository;

    @Autowired
    public MetaDataServiceImpl(final MetaDataRepository metaDataRepository) {
        this.metaDataRepository = metaDataRepository;
    }

    @Override
    public void saveMetaData(final MetaDataBean metaData) {
        metaDataRepository.save(metaData);
    }

    @Override
    public MetaDataBean findMetaDataByFile(final String fileName) {
        return metaDataRepository.findByName(fileName);
    }
}
