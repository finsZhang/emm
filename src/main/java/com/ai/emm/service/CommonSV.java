package com.ai.emm.service;

import com.ai.emm.common.domain.ResultDTO;
import com.ai.emm.exception.DBException;

import java.util.List;

/**
 * Created by lenovo on 2017/1/3.
 */
public interface CommonSV {
    public long getIdBySeqName(String seqName)throws DBException;
    <T> ResultDTO<T>  findPageListBySql(String sql, ResultDTO<T> resultDTO,Class<T> clz)throws DBException;
}
