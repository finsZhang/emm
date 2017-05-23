package com.ai.emm.ecard.dao;

import com.ai.emm.ecard.domain.CardCard;
import com.ai.emm.ecard.domain.CardTradeRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lenovo on 2016/12/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:applicationContext.xml","classpath:applicationContext-Test.xml"})
public class CustomSqlTest {
    @Autowired
    private CustomSqlDao customSqlDao;
    @Autowired
    private com.ai.emm.ecard.dao.mybatis.CardCardDao cardCardDao;
    @Test
    @Transactional()
    public void testUpdateCustomer(){
        List<CardTradeRecord> cardTradeRecords = customSqlDao.findList("SELECT new com.ai.emm.ecard.domain.CardTradeRecord(a.cardId, a.cardId)  FROM CardCard a where rownum<10");

        System.out.println();
    }
    @Test
    public void testQuery(){
        cardCardDao.findByCardId("1234444");
    }
}
