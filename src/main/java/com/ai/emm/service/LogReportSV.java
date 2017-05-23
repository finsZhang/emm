package com.ai.emm.service;

import com.ai.emm.common.domain.ResultDTO;
import com.ai.emm.vo.CardDataVO;
import com.ai.emm.vo.LogReportVO;

/**
 * Created by lenovo on 2016/12/28.
 */
public interface LogReportSV {
    public  ResultDTO<LogReportVO> queryPageList(LogReportVO logReportVO, ResultDTO<LogReportVO> resultDTO) throws Exception;
}
