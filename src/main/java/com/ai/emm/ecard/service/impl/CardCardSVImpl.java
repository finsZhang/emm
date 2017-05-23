package com.ai.emm.ecard.service.impl;

import com.ai.emm.ecard.dao.CardPresendUserDao;
import com.ai.emm.ecard.dao.MoneyRecordDao;
import com.ai.emm.ecard.domain.CardCard;
import com.ai.emm.ecard.domain.CardPresendUser;
import com.ai.emm.ecard.domain.MoneyRecord;
import com.ai.emm.ecard.service.CardCardSV;
import com.ai.emm.exception.DBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiahh on 2017-01-03.
 */
@Service
public class CardCardSVImpl implements CardCardSV {

    @Autowired
    private CardPresendUserDao cardPresendUserDao;
    @Autowired
    private MoneyRecordDao moneyRecordDao;
    public CardCard findCardCardRecord(String cardNo)throws DBException{
        return null;// cardCardDao.findCardCardByCardNo(cardNo);
    }

    public CardPresendUser findCardPresendUserByMoneyRecordSerial(String moneyRecordSerial){
        return cardPresendUserDao.findCardPresendUserByMoneyRecordSerial(moneyRecordSerial);
    }
    public MoneyRecord findMoneyRecordByMoneyRecordSerial(String moneyRecordSerial){
        return moneyRecordDao.findMoneyRecordByMoneyRecordSerial(moneyRecordSerial);
    }
}
