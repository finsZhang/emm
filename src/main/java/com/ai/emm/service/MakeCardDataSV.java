package com.ai.emm.service;

import com.ai.emm.common.domain.ResultDTO;
import com.ai.emm.domain.CardDataEntity;
import com.ai.emm.domain.CardRecordEntity;
import com.ai.emm.vo.CardDataVO;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lenovo on 2016/12/28.
 */
public interface MakeCardDataSV {
    ResultDTO<CardDataVO> queryPageList(CardDataVO cardDataVO, ResultDTO<CardDataVO> resultDTO) throws Exception;
    CardDataEntity save(CardDataEntity cardDataEntity) throws Exception;
    Iterable<CardDataEntity> save(Iterable<CardDataEntity> cardDataEntitys) throws Exception;
    Iterable<CardRecordEntity> saveCardRecords(Iterable<CardRecordEntity> cardRecordEntities) throws Exception;
    long countNumByTxtFile(String fileName) throws Exception;
    long countNumByZipFile(String fileName) throws Exception;

    List<CardDataEntity> getListByCardNoAndCardSerial(String cardNo, String cardSerial);

    List<CardDataEntity> getListByCardNo(String cardNo);

    List<CardDataEntity> getListByCardSerial(String cardSerial);
    void updateCardDataByChipSerial(String chipSerial,String cardNo,String cardSerial);
}
