package com.ai.emm.service.impl;

import com.ai.emm.dao.JmjHttpServiceDao;
import com.ai.emm.domain.LogRecordEntity;
import com.ai.emm.exception.DBException;
import com.ai.emm.service.JmjHttpServiceSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiahh on 2016-12-29.
 */
@Service
public class JmjHttpServiceSVImpl implements JmjHttpServiceSV {
    @Autowired
    private JmjHttpServiceDao jmjHttpServiceDao;
    private LogRecordEntity logRecordEntity;
    public void save(LogRecordEntity logRecordEntity) throws DBException {
        jmjHttpServiceDao.save(logRecordEntity);
    }
    public void update(LogRecordEntity logRecordEntity)throws DBException {
        jmjHttpServiceDao.save(logRecordEntity);
    }
    public LogRecordEntity selectRecord(String tradeSerial)throws DBException {
        logRecordEntity = jmjHttpServiceDao.findLogRecodEntityByTradeSerial(tradeSerial);
        return logRecordEntity;
    }
}
