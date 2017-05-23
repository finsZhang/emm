package com.ai.emm.dao;

import com.ai.emm.common.domain.ResultDTO;
import com.ai.emm.ecard.domain.CardTradeRecord;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2017/1/3.
 */
@Repository
public interface CommonDao{
        long getIdBySeqName(String seqName);
        <T> ResultDTO<T> findPageListBySql(String sql, ResultDTO<T> resultDTO,Class<T> clz);
}
