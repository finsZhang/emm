package com.ai.emm.domain;

import com.ai.emm.dao.ExampleDao;
import com.ai.emm.dao.LogRecordDao;
import com.ai.emm.service.ILogRecordSV;
import com.ai.emm.service.impl.LogRecordSVImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by lenovo on 2016/12/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class LogRecordTest {
    @Autowired
    private LogRecordDao logRecordDao;

    @Test
    @Transactional()
    public void testAddLogRecord() throws UnsupportedEncodingException {
        LogRecordEntity entity = new LogRecordEntity();
        entity.setBusinessType("01");
        entity.setCardName("");
        logRecordDao.saveAndFlush(entity);
    }
}
