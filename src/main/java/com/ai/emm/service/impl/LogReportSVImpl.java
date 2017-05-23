package com.ai.emm.service.impl;

import com.ai.emm.common.domain.ResultDTO;
import com.ai.emm.common.util.DateUtils;
import com.ai.emm.dao.CommonDao;
import com.ai.emm.service.LogReportSV;
import com.ai.emm.vo.LogReportVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lenovo on 2016/12/28.
 */
@Service
public class LogReportSVImpl implements LogReportSV{

    @Autowired
    private CommonDao commonDao;
    public  ResultDTO<LogReportVO> queryPageList(LogReportVO logReportVO, ResultDTO<LogReportVO> resultDTO) throws Exception {
        String startDate = "";
        String endDate = "";
        if(logReportVO!=null){
            if(logReportVO.getStartOperateDate()!=null){
                startDate= logReportVO.getStartOperateDate();
            }
            if(logReportVO.getStartOperateDate()!=null){
                endDate= logReportVO.getEndOperateDate();
            }
        }

        String baseSql = "SELECT COUNT(1) OPERATE_COUNT,B.ORG_CODE,B.ORG_NAME,B.BUSINESS_TYPE,'"+startDate+"~"+endDate+"' TIME_PERIOD"+
        " FROM ( "+
                "SELECT A.* "+
                        "FROM LOG_RECORD A "+
                "WHERE 1=1 ";
        StringBuffer sql = new StringBuffer(baseSql);
        if (logReportVO != null) {
            if (StringUtils.isNotBlank(logReportVO.getBusinessType()) && !("-1").equals(logReportVO.getBusinessType())) {
                sql.append(" and A.BUSINESS_TYPE='"+logReportVO.getBusinessType()+"' ");
            }

            if (StringUtils.isNotBlank(logReportVO.getOrgCodes())) {
                StringBuilder sb = new StringBuilder();
                String[] params = logReportVO.getOrgCodes().split(",");
                for (String paramStr : params) {
                    sb.append("'" + paramStr + "',");
                }
                sb.deleteCharAt(sb.length() - 1);
                sql.append(" and org_code in (" + sb.toString() + ") ");
            }

            if (StringUtils.isNotBlank(startDate)) {
                sql.append(" and TO_CHAR(A.OPERATE_DATE,'yyyy-MM-dd hh24:mi:ss') >= '"+startDate+"' ");
            }

            if (StringUtils.isNotBlank(endDate)) {
                sql.append(" and TO_CHAR(A.OPERATE_DATE,'yyyy-MM-dd hh24:mi:ss') <= '"+endDate+"' ");
            }
        }
        sql.append(" ) B GROUP BY B.ORG_CODE,B.ORG_NAME,B.BUSINESS_TYPE ");
        ResultDTO<LogReportVO> result = commonDao.findPageListBySql(sql.toString(),resultDTO,LogReportVO.class);
        return result;
    }
}
