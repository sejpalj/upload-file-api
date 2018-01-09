package com.assessment.upload_file_api.service;

import com.assessment.upload_file_api.entity.MetaDataBean;

public interface MetaDataService {

    public void saveMetaData(MetaDataBean metaData);

    public MetaDataBean findMetaDataByFile(String fileName);
}
