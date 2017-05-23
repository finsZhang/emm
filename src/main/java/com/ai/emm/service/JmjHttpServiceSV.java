package com.ai.emm.service;

import com.ai.emm.common.domain.ResultDTO;
import com.ai.emm.domain.LogRecordEntity;
import com.ai.emm.exception.DBException;

import java.util.Map;

/**
 * Created by lenovo on 2016/12/28.
 */
public interface JmjHttpServiceSV {
//    public ResultDTO queryPageList(Map param, ResultDTO resultDTO) throws Exception;

    public void save(LogRecordEntity logRecordEntity)throws DBException;
    public void update(LogRecordEntity logRecordEntity)throws DBException;
    public LogRecordEntity selectRecord(String tradeSerial)throws DBException;
}
