package com.ai.emm.dao;

import com.ai.emm.domain.ExampleBean;
import com.ai.emm.ecard.dao.CsvNewsDao;
import com.ai.emm.ecard.domain.CsvNews;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lenovo on 2016/12/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CsvNewsTest {
    @Autowired
    private CsvNewsDao csvNewsDao;
    @Test
    @Transactional()
    public void testUpdateCustomer(){
        List<CsvNews> csvNewses = csvNewsDao.findByNewsType("01");

        System.out.println();
    }
}
