package com.ai.emm.service;

import com.ai.emm.common.domain.ResultDTO;
import com.ai.emm.domain.LogRecordEntity;
import com.ai.emm.vo.CardDataVO;
import com.ai.emm.vo.LogRecordVO;

import java.util.Map;

/**
 * Created by Walter on 2016/12/28.
 */
public interface ILogRecordSV {
    public void addLogRecord(LogRecordEntity entity);
    public  ResultDTO<LogRecordVO> queryPageList(LogRecordVO logRecordVO, ResultDTO<LogRecordVO> resultDTO) throws Exception;

}
