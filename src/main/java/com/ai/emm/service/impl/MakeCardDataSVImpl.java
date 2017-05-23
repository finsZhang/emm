package com.ai.emm.service.impl;

import com.ai.emm.common.domain.ResultDTO;
import com.ai.emm.dao.CardDataDao;
import com.ai.emm.dao.CardRecordDao;
import com.ai.emm.dao.CommonDao;
import com.ai.emm.domain.CardDataEntity;
import com.ai.emm.domain.CardRecordEntity;
import com.ai.emm.service.MakeCardDataSV;
import com.ai.emm.vo.CardDataVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2016/12/28.
 */
@Service
public class MakeCardDataSVImpl implements MakeCardDataSV{
    @Autowired
    private CardDataDao cardDataDao;
    @Autowired
    private CardRecordDao cardRecordDao;
    @Autowired
    private CommonDao commonDao;
    public  ResultDTO<CardDataVO> queryPageList(CardDataVO cardDataVO, ResultDTO<CardDataVO> resultDTO) throws Exception {
        StringBuffer sql = new StringBuffer("SELECT a.*,b.id record_id,b.zip_file_name,b.txt_file_name,b.batch_num,b.receive_addr,b.creator_name,b.create_time from  card_data a,card_record b where a.card_record_id=b.id");
        String startDate = "";
        String endDate = "";
        if(cardDataVO!=null){
            if(cardDataVO.getStartOperateDate()!=null){
                startDate= cardDataVO.getStartOperateDate();
            }
            if(cardDataVO.getStartOperateDate()!=null){
                endDate= cardDataVO.getEndOperateDate();
            }
            if (StringUtils.isNotBlank(cardDataVO.getName())) {
                sql.append(" and a.name='"+cardDataVO.getName()+"'");
            }
            if (StringUtils.isNotBlank(cardDataVO.getReceiveAddr())) {
                sql.append(" and b.receive_addr like '%"+cardDataVO.getReceiveAddr()+"%'");
            }
            if (StringUtils.isNotBlank(startDate)) {
                sql.append(" and TO_CHAR(b.create_time,'yyyy-MM-dd hh24:mi:ss') >= '"+startDate+"' ");
            }

            if (StringUtils.isNotBlank(endDate)) {
                sql.append(" and TO_CHAR(b.create_time,'yyyy-MM-dd hh24:mi:ss') <= '"+endDate+"' ");
            }
            if (StringUtils.isNotBlank(cardDataVO.getIdNo())) {
                sql.append(" and a.id_no='"+cardDataVO.getIdNo()+"'");
            }
            if (StringUtils.isNotBlank(cardDataVO.getCardNo())) {
                sql.append(" and a.card_no='"+cardDataVO.getCardNo()+"'");
            }
        }
        sql.append(" order by b.id desc");

        ResultDTO<CardDataVO> result = commonDao.findPageListBySql(sql.toString(),resultDTO,CardDataVO.class);
        return result;
    }
    public CardDataEntity save(CardDataEntity cardDataEntity) throws Exception{
        return cardDataDao.save(cardDataEntity);
    }
    public Iterable<CardDataEntity> save(Iterable<CardDataEntity> cardDataEntitys) throws Exception{
        return cardDataDao.save(cardDataEntitys);
    }
    public Iterable<CardRecordEntity> saveCardRecords(Iterable<CardRecordEntity> cardRecordEntities) throws Exception{
        return cardRecordDao.save(cardRecordEntities);
    }
    public long countNumByTxtFile(String fileName) throws Exception{
        return cardRecordDao.countEqualsTxtFile(fileName);
    }
    public long countNumByZipFile(String fileName) throws Exception{
        return cardRecordDao.countEqualsZipFile(fileName);
    }

    public List<CardDataEntity> getListByCardNoAndCardSerial(String cardNo, String cardSerial){
        return  cardDataDao.getListByCardNoAndCardSerial(cardNo,cardSerial);
    }

    public List<CardDataEntity> getListByCardNo(String cardNo){
        return cardDataDao.getListByCardNo(cardNo);
    }

    public List<CardDataEntity> getListByCardSerial(String cardSerial){
        return cardDataDao.getListByCardSerial(cardSerial);
    }

    public void updateCardDataByChipSerial(String chipSerial,String cardNo,String cardSerial){
        cardDataDao.updateCardDataByChipSerial(chipSerial,cardNo,cardSerial);
    }
}
