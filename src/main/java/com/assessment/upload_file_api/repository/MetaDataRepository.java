package com.assessment.upload_file_api.repository;

import com.assessment.upload_file_api.entity.MetaDataBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaDataRepository extends JpaRepository<MetaDataBean, Integer> {

    public MetaDataBean findByName(final String name);
}
