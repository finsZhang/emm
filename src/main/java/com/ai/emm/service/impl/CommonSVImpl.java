package com.ai.emm.service.impl;

import com.ai.emm.common.domain.ResultDTO;
import com.ai.emm.dao.CommonDao;
import com.ai.emm.exception.DBException;
import com.ai.emm.service.CommonSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by lenovo on 2017/1/3.
 */
@Service
public class CommonSVImpl  implements CommonSV {
    @Autowired
    private CommonDao commonDao;
    public long getIdBySeqName(String seqName) throws DBException{
        return commonDao.getIdBySeqName(seqName);
    }
    public <T> ResultDTO<T> findPageListBySql(String sql, ResultDTO<T> resultDTO,Class<T> clz)throws DBException{
        return commonDao.findPageListBySql(sql,resultDTO,clz);
    }
}
