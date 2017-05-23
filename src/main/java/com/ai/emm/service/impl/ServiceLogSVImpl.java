package com.ai.emm.service.impl;

import com.ai.emm.dao.JmjHttpServiceDao;
import com.ai.emm.dao.ServiceLogDao;
import com.ai.emm.domain.LogRecordEntity;
import com.ai.emm.domain.ServiceLogEntity;
import com.ai.emm.exception.DBException;
import com.ai.emm.service.ServiceLogSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiahh on 2016-12-29.
 */
@Service
public class ServiceLogSVImpl implements ServiceLogSV {
    @Autowired
    private ServiceLogDao serviceLogDao;
    public void save(ServiceLogEntity entity)throws DBException {
        serviceLogDao.save(entity);
    }
    public void update(ServiceLogEntity entity)throws DBException  {
        serviceLogDao.save(entity);
    }

    public ServiceLogEntity findOne(long id)throws DBException  {
        return serviceLogDao.findOne(id);
    }

}
