package com.ai.emm.ecard.service;

import com.ai.emm.ecard.domain.CardCard;
import com.ai.emm.ecard.domain.CardPresendUser;
import com.ai.emm.ecard.domain.MoneyRecord;
import com.ai.emm.exception.DBException;

/**
 * Created by jiahh on 2017-01-03.
 */
public interface CardCardSV {
    CardCard findCardCardRecord(String cardNo)throws DBException;

    CardPresendUser findCardPresendUserByMoneyRecordSerial(String moneyRecordSerial);
    MoneyRecord findMoneyRecordByMoneyRecordSerial(String moneyRecordSerial);
}
