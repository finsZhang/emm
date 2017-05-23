package com.ai.emm.service.impl;

import com.ai.emm.common.domain.ResultDTO;
import com.ai.emm.dao.CommonDao;
import com.ai.emm.dao.LogRecordDao;
import com.ai.emm.domain.LogRecordEntity;
import com.ai.emm.service.ILogRecordSV;
import com.ai.emm.specification.LogRecordSpec;
import com.ai.emm.vo.LogRecordVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

import static org.springframework.data.jpa.domain.Specifications.where;

/**
 * Created by Walter on 2016/12/28.
 */
@Service
public class LogRecordSVImpl implements ILogRecordSV{

    @Autowired
    private LogRecordDao logRecordDao;

    public void addLogRecord(LogRecordEntity entity) {
        logRecordDao.saveAndFlush(entity);
    }

 /*   public ResultDTO queryPageList(final LogRecordVO logRecordVO, ResultDTO resultDTO) throws Exception {
        Sort s=new Sort(Sort.Direction.DESC, "operateDate");
        Pageable pageable = new PageRequest(resultDTO.getPage()-1,resultDTO.getLimit(),s);
        Specification<LogRecordEntity> logRecordEntitySpecification = new LogRecordSpec(logRecordVO);
        Page<LogRecordEntity> page = logRecordDao.findAll(where(logRecordEntitySpecification),pageable);
        resultDTO.setRows(page.getContent());
        resultDTO.setRecords((int)page.getTotalElements());
        return resultDTO;
    }*/

    @Autowired
    private CommonDao commonDao;

    public  ResultDTO<LogRecordVO> queryPageList(LogRecordVO logRecordVO, ResultDTO<LogRecordVO> resultDTO) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH24:mm:ss");
        StringBuffer sql = new StringBuffer("SELECT * FROM LOG_RECORD A where 1=1");
        String startDate = "";
        String endDate = "";
        if(logRecordVO!=null){
            if(logRecordVO.getStartOperateDate()!=null){
                startDate= logRecordVO.getStartOperateDate();
            }
            if(logRecordVO.getStartOperateDate()!=null){
                endDate= logRecordVO.getEndOperateDate();
            }
            if (StringUtils.isNotBlank(logRecordVO.getCardName())) {
                sql.append(" and a.card_name='"+logRecordVO.getCardName()+"'");
            }
            if (StringUtils.isNotBlank(logRecordVO.getIdNo())) {
                sql.append(" and a.id_no='"+logRecordVO.getIdNo()+"'");
            }
            if (StringUtils.isNotBlank(logRecordVO.getCardNo())) {
                sql.append(" and a.card_no='"+logRecordVO.getCardNo()+"'");
            }
            if (StringUtils.isNotBlank(logRecordVO.getBusinessType()) && !("-1").equals(logRecordVO.getBusinessType())) {
                sql.append(" and A.BUSINESS_TYPE='"+logRecordVO.getBusinessType()+"' ");
            }
            if (StringUtils.isNotBlank(logRecordVO.getOperateStatus()) && !("-1").equals(logRecordVO.getOperateStatus())) {
                sql.append(" and A.OPERATE_STATUS='"+logRecordVO.getOperateStatus()+"' ");
            }
            if (StringUtils.isNotBlank(logRecordVO.getOrgCodes())) {
                StringBuilder sb = new StringBuilder();
                String[] params = logRecordVO.getOrgCodes().split(",");
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
        sql.append(" ORDER BY ID DESC");
        ResultDTO<LogRecordVO> result = commonDao.findPageListBySql(sql.toString(),resultDTO,LogRecordVO.class);
        return result;
    }

}
