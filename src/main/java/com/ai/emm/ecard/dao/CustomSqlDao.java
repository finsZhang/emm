package com.ai.emm.ecard.dao;

import com.ai.emm.ecard.domain.CardTradeRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2016/12/27.
 */
@Repository
public interface CustomSqlDao{
    List<CardTradeRecord> findList(String sql);
}
