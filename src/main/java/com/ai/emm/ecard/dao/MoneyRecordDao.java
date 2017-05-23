package com.ai.emm.ecard.dao;

import com.ai.emm.ecard.domain.CardCard;
import com.ai.emm.ecard.domain.CardPresendUser;
import com.ai.emm.ecard.domain.MoneyRecord;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;


public interface MoneyRecordDao extends Repository<MoneyRecord,String> {
    MoneyRecord findMoneyRecordByMoneyRecordSerial(String moneyRecordSerial);
}