package com.ai.emm.service;

import com.ai.emm.domain.LogRecordEntity;
import com.ai.emm.domain.ServiceLogEntity;
import com.ai.emm.exception.DBException;

/**
 * Created by lenovo on 2016/12/28.
 */
public interface ServiceLogSV {
    public void save(ServiceLogEntity entity)throws DBException;
    public void update(ServiceLogEntity entity)throws DBException ;
    public ServiceLogEntity findOne(long id)throws DBException ;
}
