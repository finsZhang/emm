package com.ai.emm.dao;

import com.ai.emm.domain.LogRecordEntity;
import com.ai.emm.domain.ServiceLogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Walter on 2016/12/28.
 */
public interface ServiceLogDao extends JpaRepository<ServiceLogEntity,Long>{
    ServiceLogEntity findServiceLogEntityByServiceId(int Id);
}