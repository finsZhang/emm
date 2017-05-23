package com.ai.emm.dao;

import com.ai.emm.domain.LogRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lenovo on 2016/12/28.
 */
public interface JmjHttpServiceDao extends JpaRepository<LogRecordEntity,Long>{

    LogRecordEntity findLogRecodEntityByTradeSerial(String tradeSerial);

    //public LogRecordEntity updateInAndTradeSerial(LogRecordEntity logRecordEntity);
}
